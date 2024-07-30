package org.example.parkautoback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idt;
    private String kilometrage;
    private String montant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate datet;
    private String station;
    private String idc;
    private String card_id;

    public Transactions() {
    }

    public Transactions(String idt, String kilometrage, String montant, LocalDate datet, String station, String idc, String num_carte) {
        this.idt = idt;
        this.kilometrage = kilometrage;
        this.montant = montant;
        this.datet = datet;
        this.station = station;
        this.idc = idc;
        this.card_id = num_carte;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public LocalDate getDatet() {
        return datet;
    }

    public void setDatet(LocalDate datet) {
        this.datet = datet;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

}
