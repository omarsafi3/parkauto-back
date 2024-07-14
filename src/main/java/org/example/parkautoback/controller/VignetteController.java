package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Vignette;
import org.example.parkautoback.service.VignetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vignettes")
public class VignetteController {
    @Autowired
    private VignetteService vignetteService;

    @GetMapping
    public ResponseEntity<List<Vignette>> getAllVignettes() {
        List<Vignette> vignettes = vignetteService.getAllVignettes();
        return ResponseEntity.ok(vignettes);
    }
    @GetMapping("{id}")
    public ResponseEntity<Vignette> getVignette(@PathVariable String id) {
        Vignette vignette = vignetteService.getVignette(id);
        if (vignette != null) {
            return ResponseEntity.ok(vignette);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Vignette> addVignette(@RequestBody Vignette vignette) {
        vignetteService.addVignette(vignette);
        return ResponseEntity.ok(vignette);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vignette> updateVignette(@PathVariable String id, @RequestBody Vignette vignette) {
        Vignette existingVignette = vignetteService.getVignette(id);
        if (existingVignette != null) {
            existingVignette.setDate_deb(vignette.getDate_deb());
            existingVignette.setDate_fin(vignette.getDate_fin());
            existingVignette.setCout(vignette.getCout());
            existingVignette.setStatus(vignette.getStatus());
            existingVignette.setImmat(vignette.getImmat());
            vignetteService.updateVignette(existingVignette);
            return ResponseEntity.ok(vignette);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVignette(@PathVariable String id) {
        Vignette existingVignette = vignetteService.getVignette(id);
        if (existingVignette != null) {
            vignetteService.deleteVignette(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
