package org.example.parkautoback.controller;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.parkautoback.service.VisiteTechniqueService;
import org.example.parkautoback.entity.VisiteTechnique;

import java.util.List;

@RestController
@RequestMapping("/api/visiteTechniques")
public class VisiteTechniqueController {
    @Autowired
    private VisiteTechniqueService visiteTechniqueService;

    @GetMapping
    public ResponseEntity<List<VisiteTechnique>> getAllVisiteTechniques() {
        List<VisiteTechnique> visiteTechniques = visiteTechniqueService.getAllVisiteTechniques();
        return ResponseEntity.ok(visiteTechniques);
    }

    @GetMapping("{idvt}")
    public ResponseEntity<VisiteTechnique> getVisiteTechnique(@PathVariable String idvt) {
        VisiteTechnique visiteTechnique = visiteTechniqueService.getVisiteTechnique(idvt);
        if (visiteTechnique != null) {
            return ResponseEntity.ok(visiteTechnique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VisiteTechnique> addVisiteTechnique(@RequestBody VisiteTechnique visiteTechnique) {
        visiteTechniqueService.addVisiteTechnique(visiteTechnique);
        return ResponseEntity.ok(visiteTechnique);
    }

    @PutMapping("{idvt}")
    public ResponseEntity<VisiteTechnique> updateVisiteTechnique(@PathVariable String idvt, @RequestBody VisiteTechnique visiteTechnique) {
        VisiteTechnique existingVisiteTechnique = visiteTechniqueService.getVisiteTechnique(idvt);
        if (existingVisiteTechnique != null) {
            existingVisiteTechnique.setDate_deb(visiteTechnique.getDate_deb());
            existingVisiteTechnique.setDate_fin(visiteTechnique.getDate_fin());
            existingVisiteTechnique.setCout(visiteTechnique.getCout());
            existingVisiteTechnique.setImmat(visiteTechnique.getImmat());
            visiteTechniqueService.updateVisiteTechnique(existingVisiteTechnique);
            return ResponseEntity.ok(visiteTechnique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idvt}")
    public ResponseEntity<Void> deleteVisiteTechnique(@PathVariable String idvt) {
        VisiteTechnique existingVisiteTechnique = visiteTechniqueService.getVisiteTechnique(idvt);
        if (existingVisiteTechnique != null) {
            visiteTechniqueService.deleteVisiteTechnique(idvt);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
