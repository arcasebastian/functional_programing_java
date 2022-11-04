package com.sa.core.reader.strategies;

import com.sa.core.models.Log;


import java.io.IOException;
import java.util.stream.Stream;

public interface ReaderStrategy {
    Stream<Log> readLines(String filename) throws IOException;
}
