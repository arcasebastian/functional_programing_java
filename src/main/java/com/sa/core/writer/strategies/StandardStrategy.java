package com.sa.core.writer.strategies;

import com.sa.core.theme.Theme;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StandardStrategy implements WriterStrategy {
    private static StandardStrategy instance = null;

    private StandardStrategy() {
    }

    public static StandardStrategy getInstance() {
        if (null == instance) {
            instance = new StandardStrategy();
        }
        return instance;
    }

    @Override
    public Stream<String> getOutput(List<Map<String, String>> logs) {
        return logs.stream()
                .map(line -> line.get(Theme.DATE_TIME) + " " + line.get(Theme.LEVEL) + " " + line.get(Theme.MESSAGE));
    }
}
