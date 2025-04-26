package com.workintech.s18d2.controller;

// FruitController

import com.workintech.s18d2.Fruit;
import com.workintech.s18d2.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {  // FruitController

    @Autowired
    private FruitService fruitService;

    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }
}
