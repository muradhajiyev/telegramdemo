package com.example.telegrambotdemo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
        String chatId = update.getMessage().getChatId().toString();
        String clientId = update.getMessage().getFrom().getId().toString();

        return new SendMessage(chatId, "Aleykume salam");
    }

    @Override
    public String getBotPath() {
        return "/test";
    }
}
