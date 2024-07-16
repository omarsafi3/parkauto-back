package org.example.parkautoback.repository;

import org.example.parkautoback.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {
}
