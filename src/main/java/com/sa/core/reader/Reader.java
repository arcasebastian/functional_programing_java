package com.sa.core.reader;

import com.sa.core.functional.PredicateFunctions;
import com.sa.core.log.Level;
import com.sa.core.models.Log;
import com.sa.core.reader.strategies.ReaderStrategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Reader {
    default boolean exists() {
        File file = new File(this.getFilePath());
        return file.exists();
    }

    ;

    default boolean isReadable() {
        File file = new File(this.getFilePath());
        return file.canRead();
    }

    ;

    default List<Log> readToList() {
        List<Log> resultList = new LinkedList<>();
        if (exists() && isReadable()) {
            try {
                Stream<Log> logsList = getStrategy().readLines(this.getFilePath());
                resultList = logsList
                        .filter((log) -> !PredicateFunctions.isInList.test(getLogLevel(), log.getLevel()))
                        .limit(1000)
                        .collect(Collectors.toList());
            } catch (IOException ignored) {
            }
        }
        return resultList;
    }

    ;

    ReaderStrategy getStrategy();

    Reader setStrategy(ReaderStrategy readerStrategy);

    String getFilePath();

    Reader setFilePath(String filePath);

    List<Level> getLogLevel();

    Reader setLogLevel(List<Level> levels);
}
