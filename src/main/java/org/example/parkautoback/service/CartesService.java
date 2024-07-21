package org.example.parkautoback.service;

import org.example.parkautoback.entity.Carte;
import org.example.parkautoback.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartesService {
    private final CarteRepository carteRepository;

    @Autowired
    public CartesService(final CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public ArrayList<Carte> getAllCartes() {
        return (ArrayList<Carte>) carteRepository.findAll();
    }

    public Optional<Carte> getCarte(String id) {
        return carteRepository.findById(id);
    }

    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public Optional<Carte> updateCarte(String id, Carte updatedCarte) {
        return carteRepository.findById(id)
                .map(carte -> {
                    carte.setNum_carte(updatedCarte.getNum_carte());
                    carte.setNbr_litres(updatedCarte.getNbr_litres());
                    return carteRepository.save(carte);
                });
    }

    public void deleteCarte(String id) {
        carteRepository.deleteById(id);
    }
}
