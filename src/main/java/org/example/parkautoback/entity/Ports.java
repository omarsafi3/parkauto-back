package org.example.parkautoback.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ports")
public class Ports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String lib;

    public Ports() {
    }

    public Ports(String id, String lib) {
        this.id = id;
        this.lib = lib;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String nom) {
        this.lib = nom;
    }

}
