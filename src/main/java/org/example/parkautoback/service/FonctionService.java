package org.example.parkautoback.service;

import org.example.parkautoback.entity.Fonction;
import org.example.parkautoback.repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FonctionService {
    private final FonctionRepository FonctionRepository;

    @Autowired
    public FonctionService(final FonctionRepository FonctionRepository) {
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
                    Fonction.setPart_pre(updatedFonction.getPart_pre());
                    Fonction.setPart_post(updatedFonction.getPart_post());
                    return FonctionRepository.save(Fonction);
                });
    }

    public void deleteFonction(String idf) {
        FonctionRepository.deleteById(idf);
    }







}
