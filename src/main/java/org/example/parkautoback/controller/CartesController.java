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

    @Autowired
    private CartesService cartesService;

    @GetMapping
    public ResponseEntity<List<Carte>> getAllCartes() {
        List<Carte> cartes = cartesService.getAllCartes();
        return ResponseEntity.ok(cartes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Carte> getCarte(@PathVariable String id) {
        Carte carte = cartesService.getCarte(id);
        if (carte != null) {
            return ResponseEntity.ok(carte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carte> addCarte(@RequestBody Carte carte) {
        cartesService.addCarte(carte);
        return ResponseEntity.ok(carte);
    }

    @PutMapping("{id}")
    public ResponseEntity<Carte> updateCarte(@PathVariable String id, @RequestBody Carte carte) {
        Carte existingCarte = cartesService.getCarte(id);
        if (existingCarte != null) {
            existingCarte.setNb_litres(carte.getNb_litres());
            cartesService.updateCarte(existingCarte);
            return ResponseEntity.ok(carte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCarte(@PathVariable String id) {
        Carte existingCarte = cartesService.getCarte(id);
        if (existingCarte != null) {
            cartesService.deleteCarte(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
