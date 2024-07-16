package org.example.parkautoback.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.example.parkautoback.entity.Assurance;
import org.example.parkautoback.entity.Beneficiaire;
import org.example.parkautoback.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceService {
    private final AssuranceRepository assuranceRepository;

    @Autowired
    public AssuranceService(final AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }

    public Optional<Assurance> getAssurance(String ida) {
        return assuranceRepository.findById(ida);
    }
    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }
    public Optional<Assurance> updateAssurance(String ida, Assurance updatedAssurance) {
        return assuranceRepository.findById(ida)
                .map(assurance -> {
                    assurance.setLib(updatedAssurance.getLib());
                    return assuranceRepository.save(assurance);
                });
    }

    public void deleteAssurance(String ida) {
        assuranceRepository.deleteById(ida);
    }
}



