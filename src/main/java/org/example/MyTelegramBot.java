package org.example;

import org.example.controller.MainController;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {
    @Autowired
    private MainController mainController;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    mainController.handle(message);
                }
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Message message =callbackQuery.getMessage();
            String text = callbackQuery.getData();

            if (text.equals("list")){

                int n =  profileRepository.addTable();
                if (n != 0){
                    System.out.println("daw");
                }else {
                    System.out.println("error");
                }
            } else if (text.equals("add")) {
                profileRepository.addProfile();
            } else if (text.equals("get")) {
               String name= profileRepository.getProfileList();

                System.out.println(name);
               SendMessage sendMessage= new SendMessage();
               sendMessage.setChatId(message.getChatId());
               sendMessage.setText(name);
               send(sendMessage);
            }
        }
    }

    public void send(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getBotUsername() {
        return "instagramVideoDowloader_bot";
    }

    @Override
    public String getBotToken() {
        return "5675224004:AAGKagHHu49PFlx410IAlsRRpC0u8hUzkQE";
    }
}
