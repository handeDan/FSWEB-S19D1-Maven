package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.service.FruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllFruitsAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.getById(id);
        return fruit != null ? ResponseEntity.ok(fruit) : ResponseEntity.notFound().build();
    }

    @GetMapping("/desc")
    public List<Fruit> getAllFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public ResponseEntity<Fruit> createOrUpdateFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.update(fruit));
    }

    @PostMapping("/{name}")
    public List<Fruit> searchFruitsByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id) {
        fruitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}