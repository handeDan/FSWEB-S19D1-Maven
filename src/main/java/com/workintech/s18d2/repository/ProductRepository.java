package com.workintech.s18d2.repository;

import com.workintech.s18d2.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
