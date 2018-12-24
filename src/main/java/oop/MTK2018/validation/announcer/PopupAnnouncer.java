package oop.MTK2018.validation.announcer;

import oop.MTK2018.validation.ValidationError;

import javax.swing.*;

public class PopupAnnouncer extends Announcer {

    public void announce() {
        JOptionPane.showMessageDialog(null, combineMsg(), "ValidationError", JOptionPane.ERROR_MESSAGE);
    }

    private String combineMsg(){
        String res = "";
        for(ValidationError e: errors){
            res += e.getMsg() + "\n";
        }
        return res;
    }
}
