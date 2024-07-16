package org.example.parkautoback.service;

import org.example.parkautoback.entity.OrdreDeMission;
import org.example.parkautoback.repository.OrdreDeMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class OrdreDeMissionService {
    @Autowired
    private final OrdreDeMissionRepository ordreDeMissionRepository;

    public OrdreDeMissionService(OrdreDeMissionRepository ordreDeMissionRepository) {
        this.ordreDeMissionRepository = ordreDeMissionRepository;
    }

    public ArrayList<OrdreDeMission> getAllOrdreDeMissions() {
        return (ArrayList<OrdreDeMission>) ordreDeMissionRepository.findAll();
    }

    public Optional<OrdreDeMission> getOrdreDeMission(String idom) {
        return ordreDeMissionRepository.findById(idom);
    }

    public OrdreDeMission addOrdreDeMission(OrdreDeMission ordreDeMission) {
        return ordreDeMissionRepository.save(ordreDeMission);
    }

    public Optional<OrdreDeMission> updateOrdreDeMission(String idom, OrdreDeMission ordreDeMission) {
        return ordreDeMissionRepository.findById(idom)
                .map(OrdreDeMission -> {
                    OrdreDeMission.setDate_dep(ordreDeMission.getDate_dep());
                    OrdreDeMission.setDate_arr(ordreDeMission.getDate_arr());
                    OrdreDeMission.setAccompagnant(ordreDeMission.getAccompagnant());
                    OrdreDeMission.setObjectif(ordreDeMission.getObjectif());
                    OrdreDeMission.setObjectif(ordreDeMission.getObjectif());
                    OrdreDeMission.setTrajet(ordreDeMission.getTrajet());
                    OrdreDeMission.setEmploye_id(ordreDeMission.getEmploye_id());
                    return ordreDeMissionRepository.save(OrdreDeMission);
                });
    }

    public void deleteOrdreDeMission(String idom) {
        ordreDeMissionRepository.deleteById(idom);
    }

}