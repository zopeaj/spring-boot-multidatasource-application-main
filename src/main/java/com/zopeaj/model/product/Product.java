package com.zopeaj.model.product;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "product_db")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    @ManyToOne
    private Category category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discountinued;
    private String condition;
    @JsonIgnore
    private byte[] productImage;
    private String price;
	public UUID getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public long getUnitsInOrder() {
		return unitsInOrder;
	}
	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}
	public boolean isDiscountinued() {
		return discountinued;
	}
	public void setDiscountinued(boolean discountinued) {
		this.discountinued = discountinued;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", unitsInOrder=" + unitsInOrder + ", discountinued=" + discountinued + ", condition="
				+ condition + ", productImage=" + Arrays.toString(productImage) + ", price=" + price + "]";
	}	
}
