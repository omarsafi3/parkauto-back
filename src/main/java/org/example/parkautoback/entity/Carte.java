package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component
public class Carte {

    private String id;
    private String nb_litres;

    public Carte() {
    }

    public Carte(String id, String nb_litres) {
        this.id = id;
        this.nb_litres = nb_litres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNb_litres() {
        return nb_litres;
    }

    public void setNb_litres(String nb_litres) {
        this.nb_litres = nb_litres;
    }
}
