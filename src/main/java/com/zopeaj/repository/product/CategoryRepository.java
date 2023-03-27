package com.zopeaj.repository.product;

import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.zopeaj.model.product.Category;
import com.zopeaj.model.product.Product;


@Repository
public class CategoryRepository {
	
	@PersistenceContext(name="productdbContext")
	private EntityManager entityManager;
	
	public Set<Product> getProductDataByCategoryName(String categoryName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		Root<Category> categoryRoot = cq.from(Category.class);
		cq.select(categoryRoot).where(cb.equal(categoryRoot.get("categoryName"), categoryName));
		TypedQuery<Category> tq = entityManager.createQuery(cq);
		Category category = tq.getSingleResult();
		Set<Product> product = category.getProducts();
		return product;
	}
}
