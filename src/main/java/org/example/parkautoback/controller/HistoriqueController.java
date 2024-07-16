package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Historique;
import org.example.parkautoback.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueController {
    private final HistoriqueService historiqueService;

    @Autowired
    public HistoriqueController(final HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }


    @GetMapping
    public ResponseEntity<List<Historique>> getAllHistoriques() {
        List<Historique> historiques = historiqueService.getAllHistoriques();
        return ResponseEntity.ok(historiques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historique> getHistorique(@PathVariable String id) {
        return historiqueService.getHistorique(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Historique> addHistorique(@RequestBody Historique historique) {
        Historique savedHistorique = historiqueService.addHistorique(historique);
        return ResponseEntity.ok(savedHistorique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historique> updateHistorique(@PathVariable String id, @RequestBody Historique historique) {
        return historiqueService.updateHistorique(id, historique)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorique(@PathVariable String id) {
        historiqueService.deleteHistorique(id);
        return ResponseEntity.noContent().build();
    }
}
