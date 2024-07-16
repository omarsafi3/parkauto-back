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
    private final OrdreDeMissionService ordreDeMissionService;

    @Autowired
    public OrdreDeMissionController(final OrdreDeMissionService ordreDeMissionService) {
        this.ordreDeMissionService = ordreDeMissionService;
    }

    @GetMapping
    public ResponseEntity<List<OrdreDeMission>> getAllOrdreDeMissions() {
        List<OrdreDeMission> ordreDeMissions = ordreDeMissionService.getAllOrdreDeMissions();
        return ResponseEntity.ok(ordreDeMissions);
    }

    @GetMapping("/{idom}")
    public ResponseEntity<OrdreDeMission> getOrdreDeMission(@PathVariable String idom) {
        return ordreDeMissionService.getOrdreDeMission(idom)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdreDeMission> addOrdreDeMission(@RequestBody OrdreDeMission ordreDeMission) {
        OrdreDeMission savedOrdreDeMission = ordreDeMissionService.addOrdreDeMission(ordreDeMission);
        return ResponseEntity.ok(savedOrdreDeMission);
    }

    @PutMapping("/{idom}")
    public ResponseEntity<OrdreDeMission> updateOrdreDeMission(@PathVariable String idom, @RequestBody OrdreDeMission ordreDeMission) {
        return ordreDeMissionService.updateOrdreDeMission(idom, ordreDeMission)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idom}")
    public ResponseEntity<Void> deleteOrdreDeMission(@PathVariable String idom) {
        ordreDeMissionService.deleteOrdreDeMission(idom);
        return ResponseEntity.noContent().build();
    }
}
