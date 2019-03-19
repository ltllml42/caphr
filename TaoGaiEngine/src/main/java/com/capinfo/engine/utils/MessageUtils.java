package com.capinfo.engine.utils;

import com.capinfo.engine.message.MessageEnum;

public class MessageUtils {

    public static String showMessage(String template,Object... args){
        return String.format(template,args);
    }

    public static String showMessage(MessageEnum template, Object... args){
        return String.format(template.getMsg(),args);
    }

}
