package org.example.parkautoback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "fonction")
public class Fonction {
    @Id
    private String code;
    private String lib;
    private String part_pre;
    private String part_post;

    public Fonction() {
    }

    public Fonction(String code, String lib, String part_pre, String part_post) {
        this.code = code;
        this.lib = lib;
        this.part_pre = part_pre;
        this.part_post = part_post;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getPart_pre() {
        return part_pre;
    }

    public void setPart_pre(String part_pre) {
        this.part_pre = part_pre;
    }

    public String getPart_post() {
        return part_post;
    }

    public void setPart_post(String part_post) {
        this.part_post = part_post;
    }

}
