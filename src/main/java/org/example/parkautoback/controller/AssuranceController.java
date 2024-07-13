package org.example.parkautoback.controller;

import java.util.List;
import org.example.parkautoback.entity.Assurance;
import org.example.parkautoback.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assurances")
public class AssuranceController {
    @Autowired
    private AssuranceService assuranceService;

    public AssuranceController() {
    }

    @GetMapping
    public ResponseEntity<List<Assurance>> getAllAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        return ResponseEntity.ok(assurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assurance> getAssurance(@PathVariable String id) {
        Assurance assurance = assuranceService.getAssurance(id);
        return assurance != null ? ResponseEntity.ok(assurance) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Assurance> addAssurance(@RequestBody Assurance assurance) {
        assuranceService.addAssurance(assurance);
        return ResponseEntity.ok(assurance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assurance> updateAssurance(@PathVariable String id, @RequestBody Assurance assurance) {
        Assurance existingAssurance = assuranceService.getAssurance(id);
        if (existingAssurance != null) {
            existingAssurance.setlib(assurance.getLib());
            assuranceService.updateAssurance(existingAssurance);
            return ResponseEntity.ok(existingAssurance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable String id) {
        Assurance existingAssurance = assuranceService.getAssurance(id);
        if (existingAssurance != null) {
            assuranceService.deleteAssurance(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
