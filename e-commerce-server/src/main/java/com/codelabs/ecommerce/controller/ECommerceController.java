package com.codelabs.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.ecommerce.entity.Product;
import com.codelabs.ecommerce.entity.ProductCategory;
import com.codelabs.ecommerce.repository.ProductCategoryRepository;
import com.codelabs.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api")
public class ECommerceController {
	
	private ProductRepository productRepo;
	
	private ProductCategoryRepository productCategoryRepo;
	
	@Autowired
	ECommerceController(ProductRepository productRepo, ProductCategoryRepository productCategoryRepo){
		this.productRepo = productRepo;
		this.productCategoryRepo = productCategoryRepo;
	}

	@GetMapping(value = "/products")
	public List<Product> getProducts() {
		return productRepo.findAll();
	}
	
	@GetMapping(value = "/product-category")
	public List<ProductCategory> getProductCategories() {
		return productCategoryRepo.findAll();
	}
	
	@GetMapping(value = "/products/{id}")
	public Product getProduct(@PathVariable(name = "id") Long id) {
		return productRepo.findById(id).get();
	}
	
	@GetMapping(value = "/product-category/{id}")
	public ProductCategory getProductCategory(@PathVariable(name = "id") Long id) {
		return productCategoryRepo.findById(id).get();
	}
}
