package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Maintenance;
import org.example.parkautoback.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<ArrayList<Maintenance>> getAllMaintenances() {
        ArrayList<Maintenance> maintenances = maintenanceService.getAllMaintenances();
        return ResponseEntity.ok(maintenances);
    }

    @GetMapping("/{idm}")
    public ResponseEntity<Maintenance> getMaintenance(@PathVariable String idm) {
        return maintenanceService.getMaintenance(idm)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Maintenance> saveMaintenance(@RequestBody Maintenance maintenance) {
        Maintenance savedMaintenance = maintenanceService.saveMaintenance(maintenance);
        return ResponseEntity.ok(savedMaintenance);
    }

    @PutMapping("/{idm}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable String idm, @RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(idm, maintenance)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idm}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable String idm) {
        maintenanceService.deleteMaintenance(idm);
        return ResponseEntity.noContent().build();
    }






}
