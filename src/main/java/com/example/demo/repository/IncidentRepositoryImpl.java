package com.example.demo.repository;

import com.example.demo.entity.Incident;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class IncidentRepositoryImpl implements IncidentRepository {
    private final Map<String, Incident> incidentMap = new HashMap<>();

    @Override
    public void saveIncident(Incident incident) {
        incidentMap.put(incident.getIncidentId(), incident);
    }

    @Override
    public Incident getIncidentById(String incidentId) {
        Incident incident = incidentMap.get(incidentId);
        if(Objects.isNull(incident)){
            throw new RuntimeException("incident id not found");
        }
        return incident;
    }
}
