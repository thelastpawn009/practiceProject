package com.example.demo.entity;

import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @NonNull
    String serviceId;
    @NonNull
    SeverityEnum severity;
    String title;
    @NonNull
    String dedupKey;

}
