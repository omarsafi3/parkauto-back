package org.example.parkautoback.repository;

import org.example.parkautoback.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
}
