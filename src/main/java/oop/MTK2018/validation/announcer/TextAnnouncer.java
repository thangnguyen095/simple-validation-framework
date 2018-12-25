package oop.MTK2018.validation.announcer;

import oop.MTK2018.validation.ValidationError;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class TextAnnouncer extends Announcer {
    private JTextComponent textContainer;
    private JLabel labelContainer;

    public TextAnnouncer(JTextComponent text){
        textContainer = text;
    }

    public TextAnnouncer(JLabel label){
        labelContainer = label;
    }

    @Override
    public void announce() {
        String text = "";
        for(ValidationError e: errors){
            text += e.getMsg() + "\n";
        }
        setText(text);
    }

    @Override
    public void clear(){
        super.clear();
        setText("");
    }

    void setText(String text){
        if (labelContainer == null) {
            textContainer.setText(text);
        } else {
            labelContainer.setText(text);
        }
    }
}
