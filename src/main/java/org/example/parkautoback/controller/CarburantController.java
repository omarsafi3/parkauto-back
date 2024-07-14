package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Carburant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.parkautoback.service.CarburantService;

import java.util.List;

@RestController
@RequestMapping("/api/carburants")
public class CarburantController {

    @Autowired
    private CarburantService carburantService;

    @GetMapping
    public ResponseEntity<List<Carburant>> getAllCarburants() {
        List<Carburant> carburants = carburantService.getAllCarburants();
        return ResponseEntity.ok(carburants);
    }

    @GetMapping("{id}")
    public ResponseEntity<Carburant> getCarburant(@PathVariable String id) {
        Carburant carburant = carburantService.getCarburant(id);
        if (carburant != null) {
            return ResponseEntity.ok(carburant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carburant> addCarburant(@RequestBody Carburant carburant) {
        carburantService.addCarburant(carburant);
        return ResponseEntity.ok(carburant);
    }

    @PutMapping("{id}")
    public ResponseEntity<Carburant> updateCarburant(@PathVariable String id,@RequestBody Carburant carburant) {
        Carburant existingCarburant = carburantService.getCarburant(id);
        if (existingCarburant != null) {
            existingCarburant.setLib(carburant.getLib());
            existingCarburant.setPrix_litre(carburant.getPrix_litre());
            carburantService.updateCarburant(existingCarburant);
            return ResponseEntity.ok(carburant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCarburant(@PathVariable String id) {
        Carburant existingCarburant = carburantService.getCarburant(id);
        if (existingCarburant != null) {
            carburantService.deleteCarburant(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
