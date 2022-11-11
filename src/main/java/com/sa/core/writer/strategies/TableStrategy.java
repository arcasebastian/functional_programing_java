package com.sa.core.writer.strategies;

import com.sa.core.theme.Theme;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TableStrategy implements WriterStrategy {
    private static TableStrategy instance = null;
    private AsciiTable table = null;

    private TableStrategy() {
    }

    public static TableStrategy getInstance() {
        if (null == instance) {
            instance = new TableStrategy();
        }
        return instance;
    }

    @Override
    public Stream<String> getOutput(List<Map<String, String>> logs) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        logs.forEach(line -> {
            at.addRow(line.get(Theme.LEVEL), line.get(Theme.DATE_TIME), line.get(Theme.MESSAGE))
                    .setTextAlignment(TextAlignment.CENTER);
            at.addRule();
        });
        return Stream.of(at.render());
    }
}
