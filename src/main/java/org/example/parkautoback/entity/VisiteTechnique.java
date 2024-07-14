package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component
public class VisiteTechnique {
    private String idvt;
    private String date_deb;
    private String date_fin;
    private String cout;
    private String immat;

    public VisiteTechnique() {
    }

    public VisiteTechnique(String idvt, String date_deb, String date_fin, String cout, String immat) {
        this.idvt = idvt;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.cout = cout;
        this.immat = immat;
    }

    public String getIdvt() {
        return idvt;
    }

    public void setIdvt(String idvt) {
        this.idvt = idvt;
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

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }
}
