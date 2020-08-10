package com.stevenpj.arsenalfc;

import com.stevenpj.library.MatchUpdate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@RequestMapping("/arsenal")
public class ArsenalMatchUpdateController {

    private final Consumer<MatchUpdate> arsenalEventPublisher;

    public ArsenalMatchUpdateController(Consumer<MatchUpdate> arsenalEventPublisher) {
        this.arsenalEventPublisher = arsenalEventPublisher;
    }

    @PostMapping("/updates")
    public void sendMatchUpdate(
            @RequestParam("player") String player,
            @RequestParam("action") String action,
            @RequestParam("score") String score
    ) {
        arsenalEventPublisher.accept(new MatchUpdate("ARS", player, action, score));
    }
}
