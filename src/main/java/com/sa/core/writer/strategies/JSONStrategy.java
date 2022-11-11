package com.sa.core.writer.strategies;

import feign.gson.GsonEncoder;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JSONStrategy implements WriterStrategy {
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
    public Stream<String> getOutput(List<Map<String, String>> logs) {
        GsonEncoder as = new GsonEncoder();
        return null;
    }
}
