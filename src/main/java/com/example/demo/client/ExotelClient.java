package com.example.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class ExotelClient {

    public boolean callExotel(String number) {
        log.info("Call to extoel triggered for phone : {}", number);
        return true;
    }
}
