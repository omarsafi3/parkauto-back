package org.example.parkautoback.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "carte")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
