package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.service.VegetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesAsc() {
        return vegetableService.getAllVegetables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable Long id) {
        Vegetable fruit = vegetableService.getVegetableById(id);
        return fruit != null ? ResponseEntity.ok(fruit) : ResponseEntity.notFound().build();
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesDesc() {
        return vegetableService.getVegetablesOrderByPriceDesc();
    }

    @PostMapping
    public ResponseEntity<Vegetable> createOrUpdateVegetable(@RequestBody Vegetable vegetable) {
        return ResponseEntity.ok(vegetableService.updateVegetable(vegetable));
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchVegetablesByName(@PathVariable String name) {
        return vegetableService.getVegetablesByNameContaining(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVegetable(@PathVariable Long id) {
        vegetableService.deleteVegetable(id);
        return ResponseEntity.noContent().build();
    }
}