package org.example.controller;

import org.example.MyTelegramBot;
import org.example.repository.ProfileRepository;
import org.example.util.InlineButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Controller
public class MainController {
    @Autowired
    private MyTelegramBot myTelegramBot;

    @Autowired
    private ProfileRepository profileRepository;

    public void handle(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Assalomualaykum");
        sendMessage.setReplyMarkup(InlineButton.markup(InlineButton.rowList(
                InlineButton.row(InlineButton.button("ProfileList" ,"list"),
                        InlineButton.button("Add","add"),
                        InlineButton.button("GetName","get"))
        )));

        myTelegramBot.send(sendMessage);


    }

    public void profileList(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(profileRepository.getProfileList());
        myTelegramBot.send(sendMessage);

         int n = profileRepository.addTable();
if(n != 0){
    System.out.println("Successfully");
}else {
    System.out.println("error");
}
    }
}
