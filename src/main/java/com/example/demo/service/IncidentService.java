package com.example.demo.service;

import com.example.demo.model.Incident;
import com.example.demo.model.enums.IncidentStatus;
import com.example.demo.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> findAll() {
        return this.incidentRepository.findAll();
    }

    public Optional<Incident> findById(final Long id) {
        return this.incidentRepository.findById(id);
    }

    @Transactional
    public Incident save(Incident incident) {
        return this.incidentRepository.save(incident);
    }

    @Transactional
    public Incident updateIncidentDetails(final Long id, final Incident incident) {
        return this.incidentRepository.findById(id).map(i -> {
            i.setDescription(incident.getDescription());
            i.setName(incident.getName());

            return this.incidentRepository.save(i);
        }).orElseThrow(() -> new RuntimeException("Incident not found"));
    }

    @Transactional
    public Incident updateStatus(final Long id, final Incident incident) {
        return this.incidentRepository.findById(id).map(i -> {
            i.setStatus(incident.getStatus());

            if (IncidentStatus.CLOSED.equals(incident.getStatus())) {
                i.setClosedAt(Date.from(Instant.now()));
            }

            return this.incidentRepository.save(i);
        }).orElseThrow(() -> new RuntimeException("Incident not found"));
    }

    @Transactional
    public void deleteById(final Long id) {
        this.incidentRepository.deleteById(id);
    }

    public List<Incident> findLatest20() {
        return this.incidentRepository.findTop20ByOrderByIdIncidentDesc();
    }
}
