package org.example.parkautoback.service;

import org.example.parkautoback.entity.Carburant;
import org.example.parkautoback.repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class CarburantService {
    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantService(final CarburantRepository carburantRepository) {
        this.carburantRepository = carburantRepository;
    }

    public ArrayList<Carburant> getAllCarburants() {
        return (ArrayList<Carburant>) carburantRepository.findAll();
    }

    public Optional<Carburant> getCarburant(String idc) {
        return carburantRepository.findById(idc);
    }

    public Carburant saveCarburant(Carburant carburant) {
        return carburantRepository.save(carburant);
    }

    public Optional<Carburant> updateCarburant(String idc, Carburant updatedCarburant) {
        return carburantRepository.findById(idc)
                .map(carburant -> {
                    carburant.setLib(updatedCarburant.getLib());
                    carburant.setPrix_litre(updatedCarburant.getPrix_litre());
                    return carburantRepository.save(carburant);
                });
    }

    public void deleteCarburant(String idc) {
        carburantRepository.deleteById(idc);
    }



}
