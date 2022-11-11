package com.sa.core.writer;

import com.sa.core.enums.Format;
import com.sa.core.reader.impl.LocalFileReader;
import com.sa.core.writer.impl.ConsoleWriter;
import com.sa.core.writer.strategies.JSONStrategy;
import com.sa.core.writer.strategies.StandardStrategy;
import com.sa.core.writer.strategies.TableStrategy;
import com.sa.core.writer.strategies.WriterStrategy;

public class WriterFactory {
    public static Writer getWriter(String mod, Format type) {
        WriterStrategy strategy = getStrategy(type);
        Writer writer = null;
        //TODO implementar otros readers.
        writer = new ConsoleWriter(strategy);
        return writer;
    }

    public static Writer getWriter() {
        return getWriter(LocalFileReader.NAME, Format.STANDARD);
    }

    public static WriterStrategy getStrategy(Format type) {
        WriterStrategy strategy = null;
        if (type.equals(Format.JSON)) {
            strategy = JSONStrategy.getInstance();
        }
        if (type.equals(Format.STANDARD)) {
            strategy = StandardStrategy.getInstance();
        }
        if (type.equals(Format.TABLE)) {
            strategy = TableStrategy.getInstance();
        }
        return strategy;
    }
}
