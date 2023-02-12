package com.example.telegrambotdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@RestController
@Slf4j
public class MainController {

    private Bot bot;

    @Autowired
    public MainController(Bot bot) {
        this.bot = bot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        log.info("onUpdateReceived", update.getMessage().getText());
        log.warn(update.getMessage().getText());
        return bot.onWebhookUpdateReceived(update);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.of(Optional.of("test"));
    }

}
