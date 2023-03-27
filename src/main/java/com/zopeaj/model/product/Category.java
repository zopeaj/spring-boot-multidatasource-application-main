package com.zopeaj.model.product;

import java.util.UUID;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID categoryId;
	private String categoryName;
	@OneToMany(mappedBy="category")
	private Set<Product> products;
	
	public Category() {}
	public Category(UUID categoryId, Product product) {
		this.categoryId = categoryId;
		this.products.add(product);
	}
	
	public UUID getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}
	
	public Set<Product> getProducts(){
		return products;
	}
	
	public void setProduct(Product product) {
		this.products.add(product);
	}
	
	public String categoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
