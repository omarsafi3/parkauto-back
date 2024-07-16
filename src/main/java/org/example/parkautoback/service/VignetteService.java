package org.example.parkautoback.service;

import org.example.parkautoback.entity.Vignette;
import org.example.parkautoback.repository.VignetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VignetteService {
    @Autowired
    private final VignetteRepository vignetteRepository;

    public VignetteService(VignetteRepository vignetteRepository) {
        this.vignetteRepository = vignetteRepository;
    }

    public ArrayList<Vignette> getAllVignettes() {
        return (ArrayList<Vignette>) vignetteRepository.findAll();
    }

    public Optional<Vignette> getVignette(String idv) {
        return vignetteRepository.findById(idv);
    }

    public Vignette saveVignette(Vignette vignette) {
        return vignetteRepository.save(vignette);
    }

    public Optional<Vignette> updateVignette(String idv, Vignette vignette) {
        return vignetteRepository.findById(idv)
                .map(Vignette -> {
                    Vignette.setDate_deb(vignette.getDate_deb());
                    Vignette.setDate_fin(vignette.getDate_fin());
                    Vignette.setCout(vignette.getCout());
                    Vignette.setStatus(vignette.getStatus());
                    Vignette.setImmat(vignette.getImmat());
                    return vignetteRepository.save(Vignette);
                });
    }

    public void deleteVignette(String idv) {
        vignetteRepository.deleteById(idv);
    }


}
