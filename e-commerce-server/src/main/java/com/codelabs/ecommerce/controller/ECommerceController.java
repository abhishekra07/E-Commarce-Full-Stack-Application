package com.codelabs.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.ecommerce.entity.Product;
import com.codelabs.ecommerce.entity.ProductCategory;
import com.codelabs.ecommerce.repository.ProductCategoryRepository;
import com.codelabs.ecommerce.repository.ProductRepository;
import com.codelabs.ecommerce.service.ECommerceService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("http://localhost:4200")
public class ECommerceController {

	private ProductRepository productRepo;

	private ProductCategoryRepository productCategoryRepo;
	
	private ECommerceService service;

	@Autowired
	ECommerceController(ProductRepository productRepo, ProductCategoryRepository productCategoryRepo, ECommerceService service) {
		this.productRepo = productRepo;
		this.productCategoryRepo = productCategoryRepo;
		this.service = service;
	}

	@GetMapping(value = "/products/category/{id}")
	public List<Product> getProducts(@PathVariable(name = "id", required = false) Optional<Long> id, @RequestParam(required = false) Optional<Integer> size, @RequestParam(required = false) Optional<Integer> page) {
		return service.getProducts(id, page, size);
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
	
	@GetMapping(value = "/products/search")
	public List<Product> searchProducts(@RequestParam(name = "name", required = true) String name, @RequestParam(required = false) Optional<Integer> size, @RequestParam(required = false) Optional<Integer> page) {
		return service.searchProductsByName(name, page, size);
	}
}
