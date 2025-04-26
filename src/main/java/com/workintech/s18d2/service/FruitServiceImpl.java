package com.workintech.s18d2.service;

import com.workintech.s18d2.Fruit;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return null;
    }

    @Override
    public Fruit update(Fruit fruit) {
        Fruit fruitEntity = fruitRepository.findById(fruit.getId()).orElse(null);
        fruitRepository.update(fruitEntity);
        return fruitEntity;
    }

    @Override
    public Fruit delete(Long id) {
       // fruitRepository.deleteById(id);
        // fruitEntity
        Fruit fruitEntity = fruitRepository.findById(id).orElse(null);
         fruitRepository.delete(fruitEntity);
         return fruitEntity;
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name.toUpperCase());
    }

}