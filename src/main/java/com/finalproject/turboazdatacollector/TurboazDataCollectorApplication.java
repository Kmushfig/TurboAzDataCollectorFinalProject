package com.finalproject.turboazdatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TurboazDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurboazDataCollectorApplication.class, args);
    }

}
