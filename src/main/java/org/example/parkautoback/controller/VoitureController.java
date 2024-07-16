package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Voiture;
import org.example.parkautoback.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {
    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public ResponseEntity<List<Voiture>> getAllVoitures() {
        List<Voiture> voitures = voitureService.getAllVoitures();
        return ResponseEntity.ok(voitures);
    }

    @GetMapping("/{immat}")
    public ResponseEntity<Voiture> getVoiture(@PathVariable String immat) {
        return voitureService.getVoiture(immat)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Voiture> saveVoiture(@RequestBody Voiture voiture) {
        Voiture savedVoiture = voitureService.saveVoiture(voiture);
        return ResponseEntity.ok(savedVoiture);
    }

    @PutMapping("/{immat}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable String immat, @RequestBody Voiture voiture) {
        return voitureService.updateVoiture(immat, voiture)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{immat}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable String immat) {
        voitureService.deleteVoiture(immat);
        return ResponseEntity.noContent().build();
    }


}
