package com.christianosaurus.bot;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Service
@AllArgsConstructor
public class BotStarter {

    @PostConstruct
    public static void startBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Christianosaurus());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
