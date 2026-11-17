package com.example.demo.service;

import com.example.demo.entity.Alert;
import com.example.demo.entity.Incident;
import org.springframework.stereotype.Service;

public interface IncidentCreateService {
    public Incident createIncident(Alert alert);
    public Incident getIncident (String incidentId);
}
