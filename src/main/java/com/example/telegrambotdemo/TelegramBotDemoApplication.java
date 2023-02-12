package com.example.telegrambotdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

@SpringBootApplication
@Slf4j
public class TelegramBotDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotDemoApplication.class, args);
    }

    @Bean
    public Bot bot(SetWebhook setWebhook) {
        Bot bot = new Bot();

        log.warn("setWebhook: " + setWebhook);
        DefaultWebhook defaultWebhook = new DefaultWebhook();
        defaultWebhook.setInternalUrl("http://localhost:80");
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            log.error("cannot create TelegramBotsApi", e);
        }
        try {
            botsApi.registerBot(bot, setWebhook);
        } catch (TelegramApiException e) {
            log.error("cannot register bot", e);
        }

        log.warn("registered bot");
        return bot;
    }


    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url("https:://5472-75-102-132-70.ngrok.io").build();
    }
}
