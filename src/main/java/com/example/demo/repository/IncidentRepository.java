package com.example.demo.repository;

import com.example.demo.entity.Incident;

public interface IncidentRepository {
    public void saveIncident(Incident incident);
    public Incident getIncidentById(String incidentId);

}
