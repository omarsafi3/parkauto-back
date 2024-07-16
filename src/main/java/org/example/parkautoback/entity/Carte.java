package org.example.parkautoback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "carte")
public class Carte {
    @Id
    private String num_carte;
    private String nbr_litres;

    public Carte() {
    }

    public Carte(String num_carte, String nbr_litres) {
        this.num_carte = num_carte;
        this.nbr_litres = nbr_litres;
    }

    public String getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(String num_carte) {
        this.num_carte = num_carte;
    }

    public String getNbr_litres() {
        return nbr_litres;
    }

    public void setNbr_litres(String nbr_litres) {
        this.nbr_litres = nbr_litres;
    }


}
