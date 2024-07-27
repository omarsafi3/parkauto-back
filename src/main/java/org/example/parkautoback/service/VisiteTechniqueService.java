package org.example.parkautoback.service;

import org.example.parkautoback.entity.VisiteTechnique;
import org.example.parkautoback.repository.VisiteTechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VisiteTechniqueService {

    private final VisiteTechniqueRepository visiteTechniqueRepository;

    @Autowired
    public VisiteTechniqueService(final VisiteTechniqueRepository visiteTechniqueRepository) {
        this.visiteTechniqueRepository = visiteTechniqueRepository;
    }

    public ArrayList<VisiteTechnique> getAllVisiteTechniques() {
        return (ArrayList<VisiteTechnique>) visiteTechniqueRepository.findAll();
    }

    public Optional<VisiteTechnique> getVisiteTechnique(String idvt) {
        return visiteTechniqueRepository.findById(idvt);
    }

    public VisiteTechnique addVisiteTechnique(VisiteTechnique visiteTechnique) {
        return visiteTechniqueRepository.save(visiteTechnique);
    }

    public Optional<VisiteTechnique> updateVisiteTechnique(String idvt, VisiteTechnique visiteTechnique) {
        return visiteTechniqueRepository.findById(idvt)
                .map(VisiteTechnique -> {
                    VisiteTechnique.setDate_deb(visiteTechnique.getDate_deb());
                    VisiteTechnique.setDate_fin(visiteTechnique.getDate_fin());
                    VisiteTechnique.setCout(visiteTechnique.getCout());
                    VisiteTechnique.setStatus(visiteTechnique.getStatus());
                    VisiteTechnique.setImmat(visiteTechnique.getImmat());
                    return visiteTechniqueRepository.save(VisiteTechnique);
                });
    }

    public void deleteVisiteTechnique(String idvt) {
        visiteTechniqueRepository.deleteById(idvt);
    }




}
