package org.example.parkautoback.service;

import org.example.parkautoback.entity.Ports;
import org.example.parkautoback.repository.PortsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PortsService {
    private final PortsRepository portsRepository;

    public PortsService(PortsRepository portsRepository) {
        this.portsRepository = portsRepository;
    }

    public ArrayList<Ports> getAllPorts() {
        return (ArrayList<Ports>) portsRepository.findAll();
    }

    public Optional<Ports> getPorts(String idport) {
        return portsRepository.findById(idport);
    }

    public Ports addPorts(Ports ports) {
        return portsRepository.save(ports);
    }

    public Optional<Ports> updatePorts(String idport, Ports ports) {
        return portsRepository.findById(idport)
                .map(Ports -> {
                    Ports.setLib(ports.getLib());
                    return portsRepository.save(Ports);
                });
    }

    public void deletePorts(String idport) {
        portsRepository.deleteById(idport);
    }




}
