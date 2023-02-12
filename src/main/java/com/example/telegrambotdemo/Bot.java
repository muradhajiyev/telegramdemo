package com.example.telegrambotdemo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramWebhookBot {
    @Override
    public String getBotUsername() {
        return "MuradTelegramDemoBot";
    }

    @Override
    public String getBotToken() {
        return "6018521520:AAHIu4Y35dmQ_KUAyTJ-5GWS7lnAyokbgHU";
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return "/test";
    }
}
