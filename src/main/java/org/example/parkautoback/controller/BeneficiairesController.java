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

    @Autowired
    private BeneficiairesService beneficiairesService;

    @GetMapping
    public ResponseEntity<List<Beneficiaire>> getAllBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiairesService.getAllBeneficiaires();
        return ResponseEntity.ok(beneficiaires);
    }

    @GetMapping("{idb}")
    public ResponseEntity<Beneficiaire> getBeneficiaire(@PathVariable String idb) {
        Beneficiaire beneficiaire = beneficiairesService.getBeneficiaire(idb);
        if (beneficiaire != null) {
            return ResponseEntity.ok(beneficiaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Beneficiaire> addBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        beneficiairesService.addBeneficiaire(beneficiaire);
        return ResponseEntity.ok(beneficiaire);
    }

    @PutMapping("{idb}")
    public ResponseEntity<Beneficiaire> updateBeneficiaire(@PathVariable String idb, @RequestBody Beneficiaire beneficiaire) {
        Beneficiaire existingBeneficiaire = beneficiairesService.getBeneficiaire(idb);
        if (existingBeneficiaire != null) {
            // Update the properties of the existing Beneficiaire with those from the request body
            existingBeneficiaire.setNom(beneficiaire.getNom());
            existingBeneficiaire.setPrenom(beneficiaire.getPrenom());
            existingBeneficiaire.setDate_deb(beneficiaire.getDate_deb());
            existingBeneficiaire.setDate_fin(beneficiaire.getDate_fin());
            beneficiairesService.updateBeneficiaire(existingBeneficiaire);
            return ResponseEntity.ok(existingBeneficiaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idb}")
    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable String idb) {
        Beneficiaire existingBeneficiaire = beneficiairesService.getBeneficiaire(idb);
        if (existingBeneficiaire != null) {
            beneficiairesService.deleteBeneficiaire(idb);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
