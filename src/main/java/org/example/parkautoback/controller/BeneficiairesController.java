package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Beneficiaire;
import org.example.parkautoback.service.BeneficiairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaires")
public class BeneficiairesController {

    private final BeneficiairesService beneficiairesService;

    @Autowired
    public BeneficiairesController(BeneficiairesService beneficiairesService) {
        this.beneficiairesService = beneficiairesService;
    }

    @GetMapping
    public ResponseEntity<List<Beneficiaire>> getAllBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiairesService.getAllBeneficiaires();
        return ResponseEntity.ok(beneficiaires);
    }

    @GetMapping("/{idb}")
    public ResponseEntity<Beneficiaire> getBeneficiaire(@PathVariable String idb) {
        return beneficiairesService.getBeneficiaire(idb)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Beneficiaire> addBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        Beneficiaire savedBeneficiaire = beneficiairesService.addBeneficiaire(beneficiaire);
        return ResponseEntity.ok(savedBeneficiaire);
    }

    @PutMapping("/{idb}")
    public ResponseEntity<Beneficiaire> updateBeneficiaire(@PathVariable String idb, @RequestBody Beneficiaire beneficiaire) {
        return beneficiairesService.updateBeneficiaire(idb, beneficiaire)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idb}")
    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable String idb) {
        beneficiairesService.deleteBeneficiaire(idb);
        return ResponseEntity.noContent().build();
    }
}
