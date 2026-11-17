package com.example.demo.controller;

import com.example.demo.entity.Alert;
import com.example.demo.entity.Incident;
import com.example.demo.service.IncidentCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/incident")
public class IncidentController {

    private final IncidentCreateService incidentCreateService;

    @PostMapping("/alert")
    public Incident createIncident(@Valid @RequestBody Alert alert) {
        return incidentCreateService.createIncident(alert);
    }

    @GetMapping("/getIncident")
    public Incident getIncident (@Valid @RequestParam String incidentId) {
        return incidentCreateService.getIncident(incidentId);
    }

}
