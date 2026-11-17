package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    String incidentId;
    String serviceId;
    SeverityEnum severity;
    StatusEnum status;
    NotificationStatusEnum notificationStatus;

}
