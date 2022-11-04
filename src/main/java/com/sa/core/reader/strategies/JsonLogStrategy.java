package com.sa.core.reader.strategies;

import com.sa.core.models.Log;

import java.io.IOException;
import java.util.stream.Stream;

public class JsonLogStrategy implements ReaderStrategy {
    private static JsonLogStrategy instance = null;

    private JsonLogStrategy() {
    }

    public static JsonLogStrategy getInstance() {
        if (null == instance) {
            instance = new JsonLogStrategy();
        }
        return instance;
    }

    @Override
    public Stream<Log> readLines(String filename) throws IOException {
        return null;
    }
}
