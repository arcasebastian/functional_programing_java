package com.sa.core.reader;

import com.sa.core.Format;
import com.sa.core.reader.strategies.JsonLogStrategy;
import com.sa.core.reader.strategies.ReaderStrategy;
import com.sa.core.reader.strategies.StandardLogStrategy;

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
            strategy = JsonLogStrategy.getInstance();
        }
        if (type.equals(Format.STANDARD)) {
            strategy = StandardLogStrategy.getInstance();
        }
        return strategy;
    }
}
