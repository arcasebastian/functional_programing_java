package com.sa.core.theme;

import com.sa.core.enums.Level;

import java.time.LocalDateTime;

public interface Theme {
    public static final String LEVEL = "level";
    public static final String DATE_TIME = "dateTime";
    public static final String MESSAGE = "message";
    default String getLevelColor(Level level){
        return level.toString();
    };

    default String getDateTime(LocalDateTime dateTime){
        return dateTime.toString();
    };

    default String getMessage(String message){
        return message;
    };
}
