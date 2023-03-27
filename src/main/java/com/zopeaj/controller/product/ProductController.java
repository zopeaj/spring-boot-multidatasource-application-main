package com.zopeaj.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.zopeaj.model.product.Product;
import com.zopeaj.service.product.IProductService;


import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
	
	@Autowired(required=false)
	private IProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> addProduct (@RequestParam("name") String name, @RequestParam("file") MultipartFile file){
		return null;
	}
	
	@GetMapping("all")
	public List<Product> getAllProducts() {
		return null; 
	}
}
