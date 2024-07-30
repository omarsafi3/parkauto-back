package org.example.parkautoback.service;

import org.example.parkautoback.entity.Beneficiaire;
import org.example.parkautoback.repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiairesService {

    private final BeneficiaireRepository beneficiaireRepository;

    @Autowired
    public BeneficiairesService(BeneficiaireRepository beneficiaireRepository) {
        this.beneficiaireRepository = beneficiaireRepository;
    }

    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireRepository.findAll();
    }

    public Optional<Beneficiaire> getBeneficiaire(String idb) {
        return beneficiaireRepository.findById(idb);
    }

    public Beneficiaire addBeneficiaire(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    public Optional<Beneficiaire> updateBeneficiaire(String idb, Beneficiaire updatedBeneficiaire) {
        return beneficiaireRepository.findById(idb)
                .map(beneficiaire -> {
                    beneficiaire.setNom(updatedBeneficiaire.getNom());
                    beneficiaire.setPrenom(updatedBeneficiaire.getPrenom());
                    beneficiaire.setDate_deb(updatedBeneficiaire.getDate_deb());
                    beneficiaire.setDate_fin(updatedBeneficiaire.getDate_fin());
                    beneficiaire.setNum_carte(updatedBeneficiaire.getNum_carte());
                    beneficiaire.setCode(updatedBeneficiaire.getCode());
                    beneficiaire.setPort_id(updatedBeneficiaire.getPort_id());
                    beneficiaire.setImmat(updatedBeneficiaire.getImmat());
                    return beneficiaireRepository.save(beneficiaire);
                });
    }

    public void deleteBeneficiaire(String idb) {
        beneficiaireRepository.deleteById(idb);
    }
}
