package org.example.parkautoback.service;

import org.example.parkautoback.entity.Contrat;
import org.example.parkautoback.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ContratService {

    private final ContratRepository contratRepository;

    @Autowired
    public ContratService(final ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public ArrayList<Contrat> getAllContrats() {
        return (ArrayList<Contrat>) contratRepository.findAll();
    }

    public Optional<Contrat> getContrat(String idc) {
        return contratRepository.findById(idc);
    }

    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public Optional<Contrat> updateContrat(String idc, Contrat updatedContrat) {
        return contratRepository.findById(idc)
                .map(contrat -> {
                    contrat.setDate_debut(updatedContrat.getDate_debut());
                    contrat.setDate_fin(updatedContrat.getDate_fin());
                    contrat.setCout(updatedContrat.getCout());
                    contrat.setType(updatedContrat.getType());
                    contrat.setImmat(updatedContrat.getImmat());
                    contrat.setIda(updatedContrat.getIda());
                    return contratRepository.save(contrat);
                });
    }

    public void deleteContrat(String idc) {
        contratRepository.deleteById(idc);
    }
}
