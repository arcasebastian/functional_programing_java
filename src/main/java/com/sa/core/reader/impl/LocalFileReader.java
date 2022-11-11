package com.sa.core.reader.impl;

import com.sa.core.enums.Level;
import com.sa.core.reader.Reader;
import com.sa.core.reader.strategies.ReaderStrategy;

import java.util.List;

public final class LocalFileReader implements Reader {
    public static final String NAME = "LOCAL";
    private ReaderStrategy strategy;
    private String filepath;

    private List<Level> filteredLogLevels;
    public LocalFileReader(ReaderStrategy strategy) {
        this.strategy = strategy;
    }


    @Override
    public Reader setStrategy(ReaderStrategy readerStrategy) {
        this.strategy = readerStrategy;
        return this;
    }

    @Override
    public String getFilePath() {
        return this.filepath;
    }

    @Override
    public ReaderStrategy getStrategy() {
        return this.strategy;
    }

    @Override
    public Reader setFilePath(String filePath) {
        this.filepath = filePath;
        return this;
    }

    @Override
    public List<Level> getLogLevel() {
        return this.filteredLogLevels;
    }

    @Override
    public Reader setLogLevel(List<Level> levels) {
        this.filteredLogLevels = levels;
        return this;
    }
}
