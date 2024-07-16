package org.example.parkautoback.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.tools.javac.Main;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")

public class Maintenance {
    @Id
    private String idm;
    private String typem;
    private String description;
    private String cout;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate datem;
    private String garage;
    private String immat;

    public Maintenance() {
    }

    public Maintenance(String idm, String typem, String description, String cout, LocalDate datem, String garage, String immat) {
        this.idm = idm;
        this.typem = typem;
        this.description = description;
        this.cout = cout;
        this.datem = datem;
        this.garage = garage;
        this.immat = immat;
    }

    public String getIdm() {
        return idm;
    }

    public void setIdm(String idm) {
        this.idm = idm;
    }

    public String getTypem() {
        return typem;
    }

    public void setTypem(String typem) {
        this.typem = typem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public LocalDate getDatem() {
        return datem;
    }

    public void setDatem(LocalDate datem) {
        this.datem = datem;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }



}
