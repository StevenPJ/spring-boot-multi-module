package com.stevenpj.application;

import com.stevenpj.library.MatchUpdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication(scanBasePackages = "com.stevenpj")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void onMatchUpdate(MatchUpdate matchUpdate) {
        System.out.println(matchUpdate.toString());
    }
}
