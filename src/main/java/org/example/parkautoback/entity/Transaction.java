package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component

public class Transaction {
    private String id;
    private String kilometrage;
    private String montant;
    private String t_date;
    private String station;

    public Transaction(String id, String kilometrage, String montant, String t_date, String station) {
        this.id = id;
        this.kilometrage = kilometrage;
        this.montant = montant;
        this.t_date = t_date;
        this.station = station;
    }

    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getT_date() {
        return t_date;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
