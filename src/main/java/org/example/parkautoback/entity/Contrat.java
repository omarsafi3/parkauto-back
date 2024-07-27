package org.example.parkautoback.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_deb;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_fin;
    private String cout;
    private String type;
    private String immat;
    private String ida;

    public Contrat() {
    }

    public Contrat(String idc, LocalDate date_deb, LocalDate date_fin, String cout, String type, String immat, String ida) {
        this.idc = idc;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.cout = cout;
        this.type = type;
        this.immat = immat;
        this.ida = ida;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public LocalDate getDate_debut() {
        return date_deb;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_deb = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }



}


