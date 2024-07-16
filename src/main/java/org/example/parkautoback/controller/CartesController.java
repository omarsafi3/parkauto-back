package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Carte;
import org.example.parkautoback.service.CartesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CartesController {
    private final CartesService cartesService;
    @Autowired
    public CartesController(final CartesService cartesService) {
        this.cartesService = cartesService;
    }


    @GetMapping
    public ResponseEntity<List<Carte>> getAllCartes() {
        List<Carte> cartes = cartesService.getAllCartes();
        return ResponseEntity.ok(cartes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carte> getCarte(@PathVariable String id) {
        return cartesService.getCarte(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carte> saveCarte(@RequestBody Carte carte) {
        Carte savedCarte = cartesService.saveCarte(carte);
        return ResponseEntity.ok(savedCarte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carte> updateCarte(@PathVariable String id, @RequestBody Carte carte) {
        return cartesService.updateCarte(id, carte)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarte(@PathVariable String id) {
        cartesService.deleteCarte(id);
        return ResponseEntity.noContent().build();
    }



}
