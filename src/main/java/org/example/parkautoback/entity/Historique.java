package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component

public class Historique {

    private String id;
    private String h_date;
    private String idb;
    private String immat;
    public  Historique(){
    }

    public Historique(String id, String h_date, String idb, String immat) {
        this.id = id;
        this.h_date = h_date;
        this.idb = idb;
        this.immat = immat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getH_date() {
        return h_date;
    }

    public void setH_date(String h_date) {
        this.h_date = h_date;
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
