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

    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping
    public ResponseEntity<List<Historique>> getAllHistoriques() {
        List<Historique> historiques = historiqueService.getAllHistoriques();
        return ResponseEntity.ok(historiques);
    }

    @GetMapping("{id}")
    public ResponseEntity<Historique> getHistorique(@PathVariable String id) {
        Historique historique = historiqueService.getHistorique(id);
        if (historique != null) {
            return ResponseEntity.ok(historique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Historique> addHistorique(@RequestBody Historique historique) {
        historiqueService.addHistorique(historique);
        return ResponseEntity.ok(historique);
    }

    @PutMapping("{id}")
    public ResponseEntity<Historique> updateHistorique(@PathVariable String id, @RequestBody Historique historique) {
        Historique existingHistorique = historiqueService.getHistorique(id);
        if (existingHistorique != null) {
            existingHistorique.setH_date(historique.getH_date());
            existingHistorique.setIdb(historique.getIdb());
            existingHistorique.setImmat(historique.getImmat());
            historiqueService.updateHistorique(existingHistorique);
            return ResponseEntity.ok(historique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHistorique(@PathVariable String id) {
        Historique existingHistorique = historiqueService.getHistorique(id);
        if (existingHistorique != null) {
            historiqueService.deleteHistorique(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
