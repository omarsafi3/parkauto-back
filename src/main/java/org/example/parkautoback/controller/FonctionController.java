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

    private final FonctionService fonctionService;
    
    @Autowired
    public FonctionController(final FonctionService fonctionService) {
        this.fonctionService = fonctionService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Fonction>> getAllFonctions() {
        ArrayList<Fonction> fonctions = fonctionService.getAllFonctions();
        return ResponseEntity.ok(fonctions);
    }

    @GetMapping("/{idf}")
    public ResponseEntity<Fonction> getFonction(@PathVariable String idf) {
        return fonctionService.getFonction(idf)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fonction> saveFonction(@RequestBody Fonction fonction) {
        Fonction savedFonction = fonctionService.saveFonction(fonction);
        return ResponseEntity.ok(savedFonction);
    }

    @PutMapping("/{idf}")
    public ResponseEntity<Fonction> updateFonction(@PathVariable String idf, @RequestBody Fonction fonction) {
        return fonctionService.updateFonction(idf, fonction)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idf}")
    public ResponseEntity<Void> deleteFonction(@PathVariable String idf) {
        fonctionService.deleteFonction(idf);
        return ResponseEntity.noContent().build();
    }


}
