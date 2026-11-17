package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncidentCreateServiceImpl implements IncidentCreateService {
    private final IncidentRepository incidentRepository;
    private final static Map<String, String> phoneServiceMap = new HashMap<String, String>(
    );


    @Override
    public Incident createIncident(Alert alert) {
        log.info("Recieved alert : {} ", alert);

        Incident incident = new Incident();
        incident.setIncidentId(String.valueOf(Math.random()));
        incident.setServiceId(alert.getServiceId());
        incident.setStatus(StatusEnum.TRIGGERED);
        incident.setSeverity(alert.getSeverity());
        incident.setNotificationStatus(NotificationStatusEnum.PENDING);

        incidentRepository.saveIncident(incident);

        if(SeverityEnum.CRITICAL.equals(alert.getSeverity())){
            try {
                log.info("try call to exotel");
                incident.setNotificationStatus(NotificationStatusEnum.SENT);
                // call exotel.
            } catch (Exception e) {
                log.error("Failed call to exotel with exception : {}", e.getMessage());
                incident.setNotificationStatus(NotificationStatusEnum.FAILED);
                throw new RuntimeException(e);
            }


        }
        else {
            incident.setNotificationStatus(NotificationStatusEnum.SKIPPED);
        }
        incidentRepository.saveIncident(incident);
        return incident;
    }

    @Override
    public Incident getIncident(String incidentId) {
        return incidentRepository.getIncidentById(incidentId);
    }
}
