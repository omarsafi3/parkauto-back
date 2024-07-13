package org.example.parkautoback.controller;


import org.example.parkautoback.entity.Fonction;
import org.example.parkautoback.service.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/fonctions")
public class FonctionController {
    @Autowired
    private FonctionService fonctionService;
    public FonctionController() {
    }

    @GetMapping
    public ResponseEntity<ArrayList<Fonction>> getAllFonctions() {
        ArrayList<Fonction> fonctions = fonctionService.getAllFonctions();
        return ResponseEntity.ok(fonctions);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Fonction> getFonction(@PathVariable String code) {
        Fonction fonction = fonctionService.getFonction(code);
        return fonction != null ? ResponseEntity.ok(fonction) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Fonction> addFonction(@RequestBody Fonction fonction) {
        fonctionService.addFonction(fonction);
        return ResponseEntity.ok(fonction);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Fonction> updateFonction(@PathVariable String code,@RequestBody Fonction fonction) {
        Fonction existingFonction = fonctionService.getFonction(code);
        if (existingFonction != null) {
            existingFonction.setLib(fonction.getLib());
            existingFonction.setPart_pre(fonction.getPart_pre());
            existingFonction.setPart_post(fonction.getPart_post());
            fonctionService.updateFonction(existingFonction);
            return ResponseEntity.ok(existingFonction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteFonction(@PathVariable String code) {
        Fonction existingFonction = fonctionService.getFonction(code);
        if (existingFonction != null) {
            fonctionService.deleteFonction(code);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
