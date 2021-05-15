package com.codelabs.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelabs.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
