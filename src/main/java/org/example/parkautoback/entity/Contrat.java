package org.example.parkautoback.entity;
import org.springframework.stereotype.Component;
@Component

public class Contrat {
    private String id_contrat;
    private String immat;
    private String date_deb;
    private String date_fin;
    private String cout;
    private String type;
    public Contrat(){
    }
    public Contrat(String id_contrat, String immat, String date_deb, String date_fin, String cout, String type) {
        this.id_contrat = id_contrat;
        this.immat = immat;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.cout = cout;
        this.type = type;
    }

    public String getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(String id_contrat) {
        this.id_contrat = id_contrat;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


