package com.zopeaj.service.product;

import java.util.*;

import org.springframework.stereotype.Component;
import com.zopeaj.model.product.*;

@Component
public interface ICategoryService {
	public Set<Product> getProductDataByCategoryName(String categoryName);
}
