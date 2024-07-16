package org.example.parkautoback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "carburant")
public class Carburant {
    @Id
    private String idc;
    private String lib;
    private String prix_litre;

    public Carburant() {
    }

    public Carburant(String idc, String lib, String prix_litre) {
        this.idc = idc;
        this.lib = lib;
        this.prix_litre = prix_litre;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getPrix_litre() {
        return prix_litre;
    }

    public void setPrix_litre(String prix_litre) {
        this.prix_litre = prix_litre;
    }
    

}