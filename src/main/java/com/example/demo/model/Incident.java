package com.example.demo.model;

import com.example.demo.model.enums.IncidentStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Incident extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIncident;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private IncidentStatus status = IncidentStatus.OPEN;

    @Column(name = "closed_at")
    private Date closedAt;

    public Long getIdIncident() {
        return idIncident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }
}
