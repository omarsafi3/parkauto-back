package org.example.parkautoback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "visite_technique")
public class VisiteTechnique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idvt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_deb;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_fin;
    private String cout;
    private String status;
    private String immat;

    public VisiteTechnique() {
    }

    public VisiteTechnique(String idvt, LocalDate date_deb, LocalDate date_fin, String cout,String status, String immat) {
        this.idvt = idvt;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.cout = cout;
        this.status = status;
        this.immat = immat;
    }

    public String getIdvt() {
        return idvt;
    }

    public void setIdvt(String idvt) {
        this.idvt = idvt;
    }

    public LocalDate getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(LocalDate date_deb) {
        this.date_deb = date_deb;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
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
