package org.example.parkautoback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "historique")

public class Historique {
    @Id
    private String idh;
    private String idb;
    private String immat;

    public Historique() {
    }

    public Historique(String idh, LocalDate dateh, String idb, String immat) {
        this.idh = idh;
        this.idb = idb;
        this.immat = immat;
    }

    public String getIdh() {
        return idh;
    }

    public void setIdh(String idh) {
        this.idh = idh;
    }


    public String getIdb() {
        return idb;
    }

    public void setIdb(String idb) {
        this.idb = idb;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }




}
