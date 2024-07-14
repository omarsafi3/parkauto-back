package org.example.parkautoback.entity;
import org.springframework.stereotype.Component;
@Component

public class Beneficiaire {
    private String idb ;
    private String nom;
    private String prenom;
    private String date_deb;
    private String date_fin;

    public Beneficiaire() {
    }

    public Beneficiaire(String idb,String nom,String prenom,String date_deb,String date_fin) {
        this.idb = idb;
        this.nom = nom;
        this.prenom = prenom;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
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

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
}
