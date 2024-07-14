package org.example.parkautoback.controller;

import org.example.parkautoback.entity.OrdreDeMission;
import org.example.parkautoback.service.OrdreDeMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordres-de-mission")
public class OrdreDeMissionController {

    @Autowired
    private OrdreDeMissionService ordreDeMissionService;

    @GetMapping
    public ResponseEntity<List<OrdreDeMission>> getAllOrdresDeMission() {
        List<OrdreDeMission> ordresDeMission = ordreDeMissionService.getAllOrdresDeMission();
        return ResponseEntity.ok(ordresDeMission);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdreDeMission> getOrdreDeMission(@PathVariable String id) {
        OrdreDeMission ordreDeMission = ordreDeMissionService.getOrdreDeMission(id);
        if (ordreDeMission != null) {
            return ResponseEntity.ok(ordreDeMission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdreDeMission> addOrdreDeMission(@RequestBody OrdreDeMission ordreDeMission) {
        ordreDeMissionService.addOrdreDeMission(ordreDeMission);
        return ResponseEntity.ok(ordreDeMission);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrdreDeMission> updateOrdreDeMission(@PathVariable String id, @RequestBody OrdreDeMission ordreDeMission) {
        OrdreDeMission existingOrdreDeMission = ordreDeMissionService.getOrdreDeMission(id);
        if (existingOrdreDeMission != null) {
            existingOrdreDeMission.setObjectif(ordreDeMission.getObjectif());
            existingOrdreDeMission.setDate_dep(ordreDeMission.getDate_dep());
            existingOrdreDeMission.setDate_fin(ordreDeMission.getDate_fin());
            existingOrdreDeMission.setTrajet(ordreDeMission.getTrajet());
            existingOrdreDeMission.setCourrier(ordreDeMission.getCourrier());
            existingOrdreDeMission.setAccompagnant(ordreDeMission.getAccompagnant());
            ordreDeMissionService.updateOrdreDeMission(existingOrdreDeMission);
            return ResponseEntity.ok(ordreDeMission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrdreDeMission(@PathVariable String id) {
        OrdreDeMission existingOrdreDeMission = ordreDeMissionService.getOrdreDeMission(id);
        if (existingOrdreDeMission != null) {
            ordreDeMissionService.deleteOrdreDeMission(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
