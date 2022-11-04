package org.example.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InlineButton {
    public static InlineKeyboardButton button(String text, String callBack){
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(callBack);

        return inlineKeyboardButton;
    }

    public static List<InlineKeyboardButton> row(InlineKeyboardButton... inlineKeyboardButtons){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.addAll(Arrays.asList(inlineKeyboardButtons));

        return row;
    }

    public static List<List<InlineKeyboardButton>> rowList ( List<InlineKeyboardButton> row){
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row);

        return rowList;
    }

    public static InlineKeyboardMarkup markup (List<List<InlineKeyboardButton>> rowList){
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(rowList);
    return keyboardMarkup;
    }


}
