package org.example.parkautoback.service;

import org.example.parkautoback.entity.Voiture;
import org.example.parkautoback.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Service

public class VoitureService {
    @Autowired
    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public ArrayList<Voiture> getAllVoitures() {
        return (ArrayList<Voiture>) voitureRepository.findAll();
    }

    public Optional<Voiture> getVoiture(String immat) {
        return voitureRepository.findById(immat);
    }

    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public Optional<Voiture> updateVoiture(String immat, Voiture voiture) {
        return voitureRepository.findById(immat)
                .map(Voiture -> {
                    Voiture.setGps(voiture.getGps());
                    Voiture.setType(voiture.getType());
                    Voiture.setFonction(voiture.getFonction());
                    Voiture.setAge(voiture.getAge());
                    Voiture.setMise_en_route(voiture.getMise_en_route());
                    Voiture.setPuissance(voiture.getPuissance());
                    Voiture.setCarburant(voiture.getCarburant());
                    Voiture.setPrix(voiture.getPrix());
                    return voitureRepository.save(Voiture);

                });
    }

    public void deleteVoiture(String immat) {
        voitureRepository.deleteById(immat);
    }



}
