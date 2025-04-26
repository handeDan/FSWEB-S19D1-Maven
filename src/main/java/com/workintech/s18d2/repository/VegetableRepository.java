package com.workintech.s18d2.repository;

import com.workintech.s18d2.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findAllByOrderByPriceAsc();
    List<Vegetable> findAllByOrderByPriceDesc();
    List<Vegetable> findByNameContaining(String name);
}
