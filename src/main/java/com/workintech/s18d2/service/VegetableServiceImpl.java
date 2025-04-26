package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable saveVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable updateVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public Vegetable getVegetableById(Long id) {
        return vegetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vegetable> getAllVegetables() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> getVegetablesOrderByPriceAsc() {
        return vegetableRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Vegetable> getVegetablesOrderByPriceDesc() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vegetable> getVegetablesByNameContaining(String name) {
        return vegetableRepository.findByNameContaining(name);
    }
}