package com.sa.core.reader.strategies;

import com.sa.core.models.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class JsonLogStrategy implements ReaderStrategy {

    @Override
    public Stream<Log> readLines(String filename) throws IOException {
        return null;
    }
}
