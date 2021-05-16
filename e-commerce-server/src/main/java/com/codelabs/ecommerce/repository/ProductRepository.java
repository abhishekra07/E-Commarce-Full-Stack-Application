package com.codelabs.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelabs.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(Long id, Pageable pageable);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
	List<Product> findByNameLike(@Param("name") String name, Pageable pageable);
}
