package com.zopeaj.repository.product;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zopeaj.model.product.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, UUID>{
	Product findByname(String name);
}
