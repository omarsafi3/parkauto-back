package org.example.parkautoback.service;

import org.example.parkautoback.entity.Fonction;
import org.example.parkautoback.repository.ContratRepository;
import org.example.parkautoback.repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FonctionService {
    @Autowired
    private final FonctionRepository FonctionRepository;

    public FonctionService(FonctionRepository FonctionRepository) {
        this.FonctionRepository = FonctionRepository;
    }

    public ArrayList<Fonction> getAllFonctions() {
        return (ArrayList<Fonction>) FonctionRepository.findAll();
    }

    public Optional<Fonction> getFonction(String idf) {
        return FonctionRepository.findById(idf);
    }

    public Fonction saveFonction(Fonction Fonction) {
        return FonctionRepository.save(Fonction);
    }

    public Optional<Fonction> updateFonction(String idf, Fonction updatedFonction) {
        return FonctionRepository.findById(idf)
                .map(Fonction -> {
                    Fonction.setLib(updatedFonction.getLib());
                    return FonctionRepository.save(Fonction);
                });
    }

    public void deleteFonction(String idf) {
        FonctionRepository.deleteById(idf);
    }







}
