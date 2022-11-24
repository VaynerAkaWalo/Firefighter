package com.blamedevs.firefighter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirefighterApplication {

    @Autowired
    GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(FirefighterApplication.class, args);
    }


}
