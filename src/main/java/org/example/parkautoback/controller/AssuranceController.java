package org.example.parkautoback.controller;

import java.util.List;

import oracle.jdbc.proxy.annotation.Post;
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
    private final AssuranceService assuranceService;

    @Autowired
    public AssuranceController(final AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public ResponseEntity<List<Assurance>> getAllAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        return ResponseEntity.ok(assurances);
    }

    @GetMapping("/{ida}")
    public ResponseEntity<Assurance> getAssurance(@PathVariable String ida) {
        return assuranceService.getAssurance(ida)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping
    public ResponseEntity<Assurance> updateAssurance(@PathVariable String ida, @RequestBody Assurance assurance) {
        return assuranceService.updateAssurance(ida, assurance)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Assurance> saveAssurance(@RequestBody Assurance assurance) {
        Assurance savedAssurance = assuranceService.saveAssurance(assurance);
        return ResponseEntity.ok(savedAssurance);
    }

    @DeleteMapping("/{ida}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable String ida) {
        assuranceService.deleteAssurance(ida);
        return ResponseEntity.noContent().build();
    }

}
