package org.example.parkautoback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "ordre_de_mission")
public class OrdreDeMission {
    @Id
    private String id;
    private String employe_id;
    private String objectif;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_dep;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_arr;
    private String trajet;
    private String courrier;
    private String accompagnant;

    public OrdreDeMission() {
    }

    public OrdreDeMission(String id, String employe_id, String objectif, LocalDate date_dep, LocalDate date_arr, String trajet, String courrier, String accompagnant) {
        this.id = id;
        this.employe_id = employe_id;
        this.objectif = objectif;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        this.trajet = trajet;
        this.courrier = courrier;
        this.accompagnant = accompagnant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(String employe_id) {
        this.employe_id = employe_id;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public LocalDate getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(LocalDate date_dep) {
        this.date_dep = date_dep;
    }

    public LocalDate getDate_arr() {
        return date_arr;
    }

    public void setDate_arr(LocalDate date_arr) {
        this.date_arr = date_arr;
    }

    public String getTrajet() {
        return trajet;
    }

    public void setTrajet(String trajet) {
        this.trajet = trajet;
    }

    public String getCourrier() {
        return courrier;
    }

    public void setCourrier(String courrier) {
        this.courrier = courrier;
    }

    public String getAccompagnant() {
        return accompagnant;
    }

    public void setAccompagnant(String accompagnant) {
        this.accompagnant = accompagnant;
    }




}
