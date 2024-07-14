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

    @GetMapping("{id}")
    public ResponseEntity<Voiture> getVoiture(@PathVariable String id) {
        Voiture voiture = voitureService.getVoiture(id);
        if (voiture != null) {
            return ResponseEntity.ok(voiture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        voitureService.addVoiture(voiture);
        return ResponseEntity.ok(voiture);
    }

    @PutMapping("{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable String id, @RequestBody Voiture voiture) {
        Voiture existingVoiture = voitureService.getVoiture(id);
        if (existingVoiture != null) {
            existingVoiture.setType(voiture.getType());
            existingVoiture.setFonction(voiture.getFonction());
            existingVoiture.setAge(voiture.getAge());
            existingVoiture.setMise_en_route(voiture.getMise_en_route());
            existingVoiture.setPuissance(voiture.getPuissance());
            existingVoiture.setCarburant(voiture.getCarburant());
            existingVoiture.setPrix(voiture.getPrix());
            existingVoiture.setGps(voiture.getGps());
            voitureService.updateVoiture(existingVoiture);
            return ResponseEntity.ok(voiture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable String id) {
        Voiture existingVoiture = voitureService.getVoiture(id);
        if (existingVoiture != null) {
            voitureService.deleteVoiture(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
