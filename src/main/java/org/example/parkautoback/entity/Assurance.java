package org.example.parkautoback.entity;

import org.springframework.stereotype.Component;

@Component
public class Assurance {
    private String id;
    private String lib;

    public Assurance() {
    }

    public Assurance(String id, String lib) {
        this.id = id;
        this.lib = lib;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setlib(String lib) {
        this.lib = lib;
    }
}
