package org.example.parkautoback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.parkautoback.service.VisiteTechniqueService;
import org.example.parkautoback.entity.VisiteTechnique;

import java.util.List;

@RestController
@RequestMapping("/api/visiteTechniques")
public class VisiteTechniqueController {
    private final VisiteTechniqueService visiteTechniqueService;

    @Autowired
    public VisiteTechniqueController(final VisiteTechniqueService visiteTechniqueService) {
        this.visiteTechniqueService = visiteTechniqueService;
    }

    @GetMapping
    public ResponseEntity<List<VisiteTechnique>> getAllVisiteTechniques() {
        List<VisiteTechnique> visiteTechniques = visiteTechniqueService.getAllVisiteTechniques();
        return ResponseEntity.ok(visiteTechniques);
    }

    @GetMapping("/{idvt}")
    public ResponseEntity<VisiteTechnique> getVisiteTechnique(@PathVariable String idvt) {
        return visiteTechniqueService.getVisiteTechnique(idvt)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VisiteTechnique> addVisiteTechnique(@RequestBody VisiteTechnique visiteTechnique) {
        VisiteTechnique savedVisiteTechnique = visiteTechniqueService.addVisiteTechnique(visiteTechnique);
        return ResponseEntity.ok(savedVisiteTechnique);
    }

    @PutMapping("/{idvt}")
    public ResponseEntity<VisiteTechnique> updateVisiteTechnique(@PathVariable String idvt, @RequestBody VisiteTechnique visiteTechnique) {
        return visiteTechniqueService.updateVisiteTechnique(idvt, visiteTechnique)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idvt}")
    public ResponseEntity<Void> deleteVisiteTechnique(@PathVariable String idvt) {
        visiteTechniqueService.deleteVisiteTechnique(idvt);
        return ResponseEntity.noContent().build();
    }





}
