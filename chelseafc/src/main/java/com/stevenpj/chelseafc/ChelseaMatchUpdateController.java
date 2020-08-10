package com.stevenpj.chelseafc;

import com.stevenpj.library.MatchUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;

@RestController
@RequestMapping("/chelsea")
public class ChelseaMatchUpdateController {

    private final Consumer<MatchUpdate> chelseaEventPublisher;

    public ChelseaMatchUpdateController(Consumer<MatchUpdate> chelseaEventPublisher) {
        this.chelseaEventPublisher = chelseaEventPublisher;
    }

    @PostMapping("/updates")
    public void sendMatchUpdate(
            @RequestParam("player") String player,
            @RequestParam("action") String action,
            @RequestParam("score") String score
    ) {
        chelseaEventPublisher.accept(new MatchUpdate("CFC", player, action, score));
    }
}