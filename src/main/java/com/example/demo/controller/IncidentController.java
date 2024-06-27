package com.example.demo.controller;

import com.example.demo.model.Incident;
import com.example.demo.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return this.incidentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        return this.incidentService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return this.incidentService.save(incident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incidentDetails) {
        try {
            final Incident updatedIncident = this.incidentService.updateIncidentDetails(id, incidentDetails);
            return ResponseEntity.ok(updatedIncident);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Incident> updateIncidentStatus(@PathVariable Long id, @RequestBody Incident incident) {
        try {
            final Incident updatedIncident = this.incidentService.updateStatus(id, incident);
            return ResponseEntity.ok(updatedIncident);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        final Optional<Incident> incident = this.incidentService.findById(id);

        if (incident.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.incidentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/latest")
    public List<Incident> getLatest20Incidents() {
        return this.incidentService.findLatest20();
    }
}
