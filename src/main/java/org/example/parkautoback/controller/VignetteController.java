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
    private final VignetteService vignetteService;
    @Autowired
    public VignetteController(final VignetteService vignetteService) {
        this.vignetteService = vignetteService;
    }

    @GetMapping
    public ResponseEntity<List<Vignette>> getAllVignettes() {
        List<Vignette> vignettes = vignetteService.getAllVignettes();
        return ResponseEntity.ok(vignettes);
    }

    @GetMapping("/{idv}")
    public ResponseEntity<Vignette> getVignette(@PathVariable String idv) {
        return vignetteService.getVignette(idv)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vignette> saveVignette(@RequestBody Vignette vignette) {
        Vignette savedVignette = vignetteService.saveVignette(vignette);
        return ResponseEntity.ok(savedVignette);
    }

    @PutMapping("/{idv}")
    public ResponseEntity<Vignette> updateVignette(@PathVariable String idv, @RequestBody Vignette vignette) {
        return vignetteService.updateVignette(idv, vignette)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idv}")
    public ResponseEntity<Void> deleteVignette(@PathVariable String idv) {
        vignetteService.deleteVignette(idv);
        return ResponseEntity.noContent().build();
    }


}
