package com.zopeaj.repository.product;

import org.springframework.stereotype.Repository;
import com.zopeaj.model.product.Product;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.UUID;

@Repository	
public class ProductRepository {
	
	@PersistenceContext(name="productdbContext")
	private EntityManager entityManager;
	
	public void save(Product product) {
		entityManager.persist(product);
	}
	
	public void delete(UUID productId) {
		Product productToDelete = entityManager.find(Product.class, productId);
		if (productToDelete != null) {
			entityManager.remove(productToDelete);
		}
	}
	
	public List<Product> findAll(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> productRoot = cq.from(Product.class);
		cq.orderBy(cb.desc(productRoot.get("name")));
		List<Product> products = entityManager.createQuery(cq).getResultList();
		return products;
	}
}
