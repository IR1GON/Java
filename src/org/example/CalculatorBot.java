package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorBot extends TelegramLongPollingBot {

    private final String BOT_USERNAME = "andndnd_bot";
    private final String BOT_TOKEN = "7583959761:AAF_HJCVZORyfQbjdCdNAaW5efAFjz2GAxw";


    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            String response;
            if (userMessage.equals("/start")) {
                response = "Вітаю! Я калькулятор-бот.\n\n"
                        + "Доступні команди:\n"
                        + "/start - Запуск бота\n"
                        + "/help - Як користуватися?\n"
                        + "/about - Інформація про мене\n\n"
                        + "Просто надішли мені математичний вираз (наприклад, 5+3*2).";
            } else if (userMessage.equals("/help")) {
                response = "Як користуватися ботом:\n"
                        + "1. Використовуй команди /start, /help, /about.\n"
                        + "2. Надішли мені математичний вираз (2+2, 5*3, 10/2).\n"
                        + "3. Отримай відповідь.";
            } else if (userMessage.equals("/about")) {
                response = "Я Telegram-бот, що обчислює математичні вирази.\n\n"
                        + "Підтримувані операції:\n"
                        + "+ Додавання\n"
                        + "- Віднімання\n"
                        + "* Множення\n"
                        + "/ Ділення\n"
                        + "% Залишок від ділення\n"
                        + "^ Піднесення до степеня";
            } else {
                response = calculateExpression(userMessage);
            }

            sendResponse(chatId, response);
        }
    }

    private void sendResponse(Long chatId, String response) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(response);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String calculateExpression(String expression) {
        try {
            expression = expression.replaceAll("\\^", "**");

            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(expression);
            return "Результат: " + result;
        } catch (ScriptException e) {
            return "Помилка у виразі! Спробуй ще раз.";
        }
    }
}