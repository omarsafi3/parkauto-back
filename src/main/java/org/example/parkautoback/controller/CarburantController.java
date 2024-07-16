package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Carburant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.parkautoback.service.CarburantService;

import java.util.List;

@RestController
@RequestMapping("/api/carburants")
public class CarburantController {
    private final CarburantService carburantService;
    @Autowired
    public CarburantController(final CarburantService carburantService) {
        this.carburantService = carburantService;
    }

    @GetMapping
    public ResponseEntity<List<Carburant>> getAllCarburants() {
        List<Carburant> carburants = carburantService.getAllCarburants();
        return ResponseEntity.ok(carburants);
    }

    @GetMapping("/{idc}")
    public ResponseEntity<Carburant> getCarburant(@PathVariable String idc) {
        return carburantService.getCarburant(idc)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{idc}")
    public ResponseEntity<Carburant> updateCarburant(@PathVariable String idc, @RequestBody Carburant carburant) {
        return carburantService.updateCarburant(idc, carburant)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carburant> saveCarburant(@RequestBody Carburant carburant) {
        Carburant savedCarburant = carburantService.saveCarburant(carburant);
        return ResponseEntity.ok(savedCarburant);
    }

    @DeleteMapping("/{idc}")
    public ResponseEntity<Void> deleteCarburant(@PathVariable String idc) {
        carburantService.deleteCarburant(idc);
        return ResponseEntity.noContent().build();
    }





}
