package com.sa.core.reader.strategies;

import com.sa.core.functional.UtilsFunctions;
import com.sa.core.models.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class StandardStrategy implements ReaderStrategy {

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
    public Stream<Log> readLines(String filename) throws IOException {
        return Files.newBufferedReader(Paths.get(filename))
                .lines()
                .filter(line -> line.matches("^20[0-9]{2}.*\\[\\S*\\].*$"))
                .map(this::parseLine);
    }

    private Log parseLine(String line) {
        Log logLine = new Log();
        logLine.setLevel(UtilsFunctions.extractString.apply(line, "\\[(\\S*)\\]"))
                .setDateTime(getDateFromLine(line))
                .setMessage(UtilsFunctions.extractString.apply(line, ": (.*)"));
        return logLine;
    }

    private LocalDateTime getDateFromLine(String line) {
        return UtilsFunctions.toLocalDateTime
                .apply(UtilsFunctions.extractString.apply(line, "(.*)Z"));
    }
}
