package com.workintech.s18d2;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl extends FruitService {

    private final com.workintech.s18d2.FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(com.workintech.s18d2.FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<com.workintech.s18d2.Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}
