package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Contrat;
import org.example.parkautoback.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        List<Contrat> contrats = contratService.getAllContrats();
        return ResponseEntity.ok(contrats);
    }

    @GetMapping("{id_contrat}")
    public ResponseEntity<Contrat> getContrat(@PathVariable String id_contrat) {
        Contrat contrat = contratService.getContrat(id_contrat);
        if (contrat != null) {
            return ResponseEntity.ok(contrat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        contratService.addContrat(contrat);
        return ResponseEntity.ok(contrat);
    }

    @PutMapping("{id_contrat}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable String id_contrat, @RequestBody Contrat contrat) {
        Contrat existingContrat = contratService.getContrat(id_contrat);
        if (existingContrat != null) {
            existingContrat.setImmat(contrat.getImmat());
            existingContrat.setDate_deb(contrat.getDate_deb());
            existingContrat.setDate_fin(contrat.getDate_fin());
            existingContrat.setCout(contrat.getCout());
            existingContrat.setType(contrat.getType());
            contratService.updateContrat(existingContrat);
            return ResponseEntity.ok(existingContrat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id_contrat}")
    public ResponseEntity<Void> deleteContrat(@PathVariable String id_contrat) {
        Contrat existingContrat = contratService.getContrat(id_contrat);
        if (existingContrat != null) {
            contratService.deleteContrat(id_contrat);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
