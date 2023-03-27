package com.zopeaj.service.product;

import java.util.*;
import org.springframework.stereotype.Component;
import com.zopeaj.model.product.Product;

@Component
public interface IProductService {
	public Product creatProduct(Product product);	
	public void removeProduct(UUID productId);
	public List<Product> getAllProducts();	
}
