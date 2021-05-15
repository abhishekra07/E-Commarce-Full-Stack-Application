package com.codelabs.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelabs.ecommerce.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
