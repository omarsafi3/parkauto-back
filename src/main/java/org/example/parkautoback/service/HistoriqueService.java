package org.example.parkautoback.service;

import org.example.parkautoback.entity.Historique;
import org.example.parkautoback.repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class HistoriqueService {
    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public HistoriqueService(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    public ArrayList<Historique> getAllHistoriques() {
        return (ArrayList<Historique>) historiqueRepository.findAll();
    }

    public Optional<Historique> getHistorique(String id) {
        return historiqueRepository.findById(id);
    }

    public Historique addHistorique(Historique historique) {
        return historiqueRepository.save(historique);
    }

    public Optional<Historique> updateHistorique(Historique historique) {
        return historiqueRepository.findById(historique.getIdh())
                .map(Historique -> {
                    Historique.setDateh(historique.getDateh());
                    Historique.setIdb(historique.getIdb());
                    Historique.setImmat(historique.getImmat());
                    return historiqueRepository.save(Historique);
                });
    }

    public void deleteHistorique(String id) {
        historiqueRepository.deleteById(id);
    }


}
