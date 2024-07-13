package org.example.parkautoback.entity;
import org.example.parkautoback.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Assurance {
    private String id;
    private String lib;

    @Autowired
    private DatabaseService databaseService;

    public Assurance(String id, String lib) {
        this.id = id;
        this.lib = lib;
    }

    public String authenticate(Assurance assurance) {
        return databaseService.authenticate(assurance.getId(), assurance.getLib());
    }

    public String printAllAssurances() {
        return databaseService.printAllAssurances();

    }

    public String getId() {
        return id;
    }


    public String getLib() {
        return lib;
    }
}


