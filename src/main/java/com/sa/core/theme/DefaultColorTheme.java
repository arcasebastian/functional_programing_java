package com.sa.core.theme;

import com.sa.cli.color.Color;
import com.sa.cli.color.ColorVariant;
import com.sa.cli.color.Colorize;
import com.sa.core.enums.Level;

import java.time.LocalDateTime;

public class DefaultColorTheme implements Theme {
    @Override
    public String getLevelColor(Level level) {
        String response = level.toString();
        switch (level) {
            case INFO:
                response = Colorize.colorize(level.toString(), Color.BLUE, ColorVariant.BRIGHT);
                break;
            case DEBUG:
                response = Colorize.colorize(level.toString(), Color.PURPLE, ColorVariant.BRIGHT);
                break;
            case ERROR:
                response = Colorize.colorize(level.toString(), Color.RED, ColorVariant.BRIGHT);
                break;
            case WARNING:
                response = Colorize.colorize(level.toString(), Color.YELLOW, ColorVariant.BRIGHT);
                break;
        }
        return response;
    }

    @Override
    public String getDateTime(LocalDateTime dateTime) {
        return dateTime.toString();
    }

    @Override
    public String getMessage(String message) {
        return message;
    }
}
