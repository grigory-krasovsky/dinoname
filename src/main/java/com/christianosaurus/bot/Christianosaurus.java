package com.christianosaurus.bot;

import at.mukprojects.giphy4j.exception.GiphyException;
import com.christianosaurus.bot.data.Dinosaur;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputContactMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.christianosaurus.bot.giphy.GiphyService.getGif;
import static com.christianosaurus.bot.utils.PropertyService.getProperty;

@RequiredArgsConstructor
@Service
public class Christianosaurus extends TelegramLongPollingBot {

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        handleInlineQuery(update);
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        return "Christosaurusbot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return getProperty("bot.token");
    }

    private void handleInlineQuery(Update update) throws TelegramApiException, GiphyException {
        if (isInlineQueryEvent(update)) {
            AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
            answerInlineQuery.setInlineQueryId(update.getInlineQuery().getId());
            answerInlineQuery.setCacheTime(1);
            InlineQueryResultArticle result = new InlineQueryResultArticle();

            String text = update.getInlineQuery().getQuery();
            String response = "";
            List<Dinosaur> dinosaurs = Dinosaur.initList();

            try {
                LocalDate bDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                int v = bDate.getMonthValue();
                response = String.format("До крещения тебя звали %s\n%s",
                        dinosaurs.get(v).getAltName(),
                        getGif(dinosaurs.get(v)));
            } catch (Exception e) {

                response = "Введи дату рождения в формате гггг/мм/дд";
            }

            result.setId("1");
            result.setTitle(response);


            InputMessageContent inputMessageContent = new InputTextMessageContent(response);
            result.setInputMessageContent(inputMessageContent);
            result.setDescription("Каким динозавром ты был до крещения?");
            List<InlineQueryResult> results = new ArrayList<>();
            results.add(result);
            answerInlineQuery.setResults(results);
            execute(answerInlineQuery);
        }
    }

    private boolean isInlineQueryEvent(Update update) {
        return update.hasInlineQuery();
    }
}
