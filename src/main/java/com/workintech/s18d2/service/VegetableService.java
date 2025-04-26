package com.workintech.s18d2.service;

import com.workintech.s18d2.Vegetable;
import java.util.List;

public interface VegetableService {
    Vegetable saveVegetable(Vegetable vegetable);
    Vegetable updateVegetable(Vegetable vegetable);
    void deleteVegetable(Long id);
    Vegetable getVegetableById(Long id);
    List<Vegetable> getAllVegetables();
    List<Vegetable> getVegetablesOrderByPriceAsc();
    List<Vegetable> getVegetablesOrderByPriceDesc();
    List<Vegetable> getVegetablesByNameContaining(String name);
}