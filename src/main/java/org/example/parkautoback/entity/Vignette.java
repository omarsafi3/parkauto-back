package org.example.parkautoback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "vignette")
public class Vignette {
    @Id
    private String idv;
    private String date_deb;
    private String date_fin;
    private String cout;
    private String status;
    private String immat;

    public Vignette() {
    }

    public Vignette(String idv, String date_deb, String date_fin, String cout, String status, String immat) {
        this.idv = idv;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.cout = cout;
        this.status = status;
        this.immat = immat;
    }

    public String getIdv() {
        return idv;
    }

    public void setIdv(String idv) {
        this.idv = idv;
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

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }



}
