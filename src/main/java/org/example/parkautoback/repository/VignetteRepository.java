package org.example.parkautoback.repository;

import org.example.parkautoback.entity.Vignette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VignetteRepository extends JpaRepository<Vignette, String> {
}
