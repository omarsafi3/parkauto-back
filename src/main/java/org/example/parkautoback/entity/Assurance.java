package org.example.parkautoback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "assurance")
public class Assurance {
    @Id
    private String ida;
    private String libelle;


    public Assurance() {
    }

    public Assurance(String ida, String libelle) {
        this.ida = ida;
        this.libelle = libelle;
    }

    public String getIda() {
        return ida;
    }

    public void setId(String id) {
        this.ida = id;
    }

    public String getLib() {
        return libelle;
    }

    public void setLib(String lib) {
        this.libelle = lib;
    }
}