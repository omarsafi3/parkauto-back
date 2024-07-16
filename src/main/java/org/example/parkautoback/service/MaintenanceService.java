package org.example.parkautoback.service;

import org.example.parkautoback.entity.Maintenance;
import org.example.parkautoback.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService(final MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }


    public ArrayList<Maintenance> getAllMaintenances() {
        return (ArrayList<Maintenance>) maintenanceRepository.findAll();
    }

    public Optional<Maintenance> getMaintenance(String idm) {
        return maintenanceRepository.findById(idm);
    }

    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public Optional<Maintenance> updateMaintenance(String idm, Maintenance maintenance) {
        return maintenanceRepository.findById(idm)
                .map(Maintenance -> {
                    Maintenance.setTypem(maintenance.getTypem());
                    Maintenance.setDatem(maintenance.getDatem());
                    Maintenance.setCout(maintenance.getCout());
                    Maintenance.setDescription(maintenance.getDescription());
                    Maintenance.setGarage(maintenance.getGarage());
                    Maintenance.setImmat(maintenance.getImmat());
                    return maintenanceRepository.save(Maintenance);
                });
    }

    public void deleteMaintenance(String idm) {
        maintenanceRepository.deleteById(idm);
    }



}
