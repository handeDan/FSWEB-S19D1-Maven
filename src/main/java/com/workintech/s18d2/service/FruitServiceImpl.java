package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit update(Fruit fruit) {
        Fruit fruitEntity = fruitRepository.findById(fruit.getId()).orElse(null);
        fruitEntity.setName(fruit.getName());
        fruitEntity.setPrice(fruit.getPrice());
        fruitEntity.setFruitType(fruit.getFruitType());
        fruitRepository.save(fruitEntity);
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

    public Fruit getById(Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found with id: " + id));
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