package com.sa.core.reader;

import com.sa.core.enums.Format;
import com.sa.core.reader.impl.LocalFileReader;
import com.sa.core.reader.strategies.JSONStrategy;
import com.sa.core.reader.strategies.ReaderStrategy;
import com.sa.core.reader.strategies.StandardStrategy;

public class ReaderFactory {
    public static Reader getReader(String mod, Format type) {
        ReaderStrategy strategy = getStrategy(type);
        Reader reader = null;
        //TODO implementar otros readers.
        reader = new LocalFileReader(strategy);
        return reader;
    }

    public static Reader getReader() {
        return getReader(LocalFileReader.NAME, Format.STANDARD);
    }

    public static ReaderStrategy getStrategy(Format type) {
        ReaderStrategy strategy = null;
        if (type.equals(Format.JSON)) {
            strategy = JSONStrategy.getInstance();
        }
        if (type.equals(Format.STANDARD)) {
            strategy = StandardStrategy.getInstance();
        }
        return strategy;
    }
}
