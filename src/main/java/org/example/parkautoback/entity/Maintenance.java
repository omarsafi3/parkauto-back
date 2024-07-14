package org.example.parkautoback.entity;
import org.springframework.stereotype.Component;
@Component

public class Maintenance {
    private String id;
    private String type;
    private String description;
    private String cout;
    private String m_date;
    private String garage;

    public Maintenance() {
    }

    public Maintenance(String id,String type,String description,String cout,String m_date,String garage) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.cout = cout;
        this.m_date = m_date;
        this.garage = garage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }
}
