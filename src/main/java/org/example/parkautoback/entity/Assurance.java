package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component
public class Assurance {
    private String Id;
    private String lib;

    public Assurance() {
    }

    public Assurance(String assuranceId, String description) {
        this.Id = Id;
        this.lib = description;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getLib() {
        return lib;
    }

    public void setlib(String lib) {
        this.lib = lib;
    }
}
