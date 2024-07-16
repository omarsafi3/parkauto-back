package org.example.parkautoback.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Port;
import java.time.LocalDate;

@Entity
@Table(name = "beneficiaire")
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idb ;
    private String nom;
    private String prenom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_deb;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_fin;
    private String num_carte;
    private String code;
    private String port_id;



    public Beneficiaire() {
    }

    public Beneficiaire(String idb, String nom, String prenom, LocalDate date_deb, LocalDate date_fin, String num_carte, String code, String port_id) {
        this.idb = idb;
        this.nom = nom;
        this.prenom = prenom;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.num_carte = num_carte;
        this.code = code;
        this.port_id = port_id;
    }

    public String getIdb() {
        return idb;
    }

    public void setIdb(String idb) {
        this.idb = idb;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(LocalDate date_deb) {
        this.date_deb = date_deb;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public String getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(String num_carte) {
        this.num_carte = num_carte;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPort_id() {
        return port_id;
    }

    public void setPort_id(String port_id) {
        this.port_id = port_id;
    }
}
