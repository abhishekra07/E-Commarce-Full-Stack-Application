package com.codelabs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codelabs.ecommerce.entity.Product;
import com.codelabs.ecommerce.repository.ProductRepository;

@Service
public class ECommerceService {
	
	private ProductRepository productRepo;
	
	public ECommerceService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getProducts(Optional<Long> id, Optional<Integer> page, Optional<Integer> size) {
		Long categoryId = id.isPresent() ? id.get() : 1;
		int pageSize = size.isPresent() ? size.get() : 10;
		int pageNumber = page.isPresent() ? page.get() : 0;
		return productRepo.findByCategoryId(categoryId, PageRequest.of(pageNumber, pageSize));
	}

	public List<Product> searchProductsByName(String name, Optional<Integer> page, Optional<Integer> size) {
		int pageSize = size.isPresent() ? size.get() : 10;
		int pageNumber = page.isPresent() ? page.get() : 0;
		return productRepo.findByNameLike(name, PageRequest.of(pageNumber, pageSize));
	}

}
