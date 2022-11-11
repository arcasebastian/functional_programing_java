package com.sa.core.reader.strategies;

import com.sa.core.models.Log;

import java.io.IOException;
import java.util.stream.Stream;

public class JSONStrategy implements ReaderStrategy {
    private static JSONStrategy instance = null;

    private JSONStrategy() {
    }

    public static JSONStrategy getInstance() {
        if (null == instance) {
            instance = new JSONStrategy();
        }
        return instance;
    }

    @Override
    public Stream<Log> readLines(String filename) throws IOException {
        return null;
    }
}
