package org.example.parkautoback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    private String immat;
    private String type;
    private String fonction;
    private String age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate mise_en_route;
    private String puissance;
    private String carburant;
    private String prix;
    private String gps;

    public Voiture() {
    }

    public Voiture(String immat, String type, String fonction, String age, LocalDate mise_en_route, String puissance, String carburant, String prix, String gps) {
        this.immat = immat;
        this.type = type;
        this.fonction = fonction;
        this.age = age;
        this.mise_en_route = mise_en_route;
        this.puissance = puissance;
        this.carburant = carburant;
        this.prix = prix;
        this.gps = gps;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDate getMise_en_route() {
        return mise_en_route;
    }

    public void setMise_en_route(LocalDate mise_en_route) {
        this.mise_en_route = mise_en_route;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }



}
