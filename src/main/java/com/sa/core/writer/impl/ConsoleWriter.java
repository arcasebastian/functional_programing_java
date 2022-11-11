package com.sa.core.writer.impl;

import com.sa.core.enums.ColorTheme;
import com.sa.core.enums.OutputLevel;
import com.sa.core.models.Log;
import com.sa.core.theme.DefaultColorTheme;
import com.sa.core.theme.NoColorTheme;
import com.sa.core.theme.Theme;
import com.sa.core.writer.Writer;
import com.sa.core.writer.strategies.WriterStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleWriter implements Writer {
    WriterStrategy formatterStrategy;
    Theme theme = null;

    public ConsoleWriter(WriterStrategy formatterStrategy) {
        this.formatterStrategy = formatterStrategy;
    }

    @Override
    public Writer setStrategy(WriterStrategy strategy) {
        return this;
    }

    @Override
    public Writer setColorTheme(ColorTheme colorTheme) {
        switch (colorTheme) {
            case NO_COLOR:
                this.theme = new NoColorTheme();
                break;
            case COLOR:
                this.theme = new DefaultColorTheme();
                break;
        }
        return this;
    }

    @Override
    public Writer setOutputLevel(OutputLevel outputLevel) {
        return this;
    }

    @Override
    public void write(List<Log> logs) {
        List<Map<String, String>> list = logs.stream()
                .map(this::useTheme)
                .collect(Collectors.toList());
        formatterStrategy.getOutput(list)
                .forEach(System.out::println);
    }

    @Override
    public Theme getTheme() {
        return this.theme;
    }
}
