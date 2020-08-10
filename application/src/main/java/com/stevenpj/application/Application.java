package com.stevenpj.application;

import com.stevenpj.library.MatchUpdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @JmsListener(destination = "matchUpdates", containerFactory = "myFactory")
    public void onMatchUpdate(MatchUpdate matchUpdate) {
        System.out.println(matchUpdate.toString());
    }
}
