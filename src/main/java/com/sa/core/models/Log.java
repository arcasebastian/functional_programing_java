package com.sa.core.models;

import com.sa.cli.color.Color;
import com.sa.cli.color.ColorVariant;
import com.sa.cli.color.Colorize;
import com.sa.core.log.Level;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.StringJoiner;

public class Log {
    private Level level;
    private LocalDateTime dateTime;
    private String message;
    private HashMap<String, Object> extraParams;

    public Log setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Level getLevel() {
        return this.level;
    }

    public Log setLevel(String level) {
        try {
            this.level = Enum.valueOf(Level.class, level);
        } catch (IllegalArgumentException e) {
            this.level = Enum.valueOf(Level.class, level.toUpperCase());
        }
        return this;
    }

    public Log setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Log.class.getSimpleName() + "[", "]")
                .add(Colorize.colorize("level='" + level + "'", Color.RED, ColorVariant.BRIGHT))
                .add("dateTime=" + dateTime)
                .add("message='" + message + "'")
                .add("extraParams=" + extraParams)
                .toString();
    }

}
