package org.example.parkautoback.controller;

import org.example.parkautoback.entity.Ports;
import org.example.parkautoback.service.PortsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ports")
public class PortsController {
    private final PortsService portsService;
    @Autowired
    public PortsController(final PortsService portsService) {
        this.portsService = portsService;
    }

    @GetMapping
    public ResponseEntity<List<Ports>> getAllPorts() {
        List<Ports> ports = portsService.getAllPorts();
        return ResponseEntity.ok(ports);
    }

    @GetMapping("/{idport}")
    public ResponseEntity<Ports> getPorts(@PathVariable String idport) {
        return portsService.getPorts(idport)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ports> addPorts(@RequestBody Ports ports) {
        Ports savedPorts = portsService.addPorts(ports);
        return ResponseEntity.ok(savedPorts);
    }

    @PutMapping("/{idport}")
    public ResponseEntity<Ports> updatePorts(@PathVariable String idport,@RequestBody Ports ports) {
        return portsService.updatePorts(idport, ports)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idport}")
    public ResponseEntity<Void> deletePorts(@PathVariable String idport) {
        portsService.deletePorts(idport);
        return ResponseEntity.noContent().build();
    }

}
