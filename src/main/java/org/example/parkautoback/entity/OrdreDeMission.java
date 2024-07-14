package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component
public class OrdreDeMission {
    private String id;
    private String objectif;
    private String date_dep;
    private String date_fin;
    private String trajet;
    private String courrier;
    private String accompagnant;

    public OrdreDeMission() {
    }

    public OrdreDeMission(String id, String objectif, String date_dep, String date_fin, String trajet, String courrier, String accompagnant) {
        this.id = id;
        this.objectif = objectif;
        this.date_dep = date_dep;
        this.date_fin = date_fin;
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

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(String date_dep) {
        this.date_dep = date_dep;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
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
