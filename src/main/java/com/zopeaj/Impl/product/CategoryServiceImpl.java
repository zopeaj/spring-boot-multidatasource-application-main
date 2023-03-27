package com.zopeaj.Impl.product;


import java.util.Set;

import org.springframework.stereotype.Service;

import com.zopeaj.model.product.Product;
import com.zopeaj.service.product.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public Set<Product> getProductDataByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
