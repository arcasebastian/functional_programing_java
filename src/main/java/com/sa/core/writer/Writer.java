package com.sa.core.writer;

import com.sa.core.enums.ColorTheme;
import com.sa.core.enums.OutputLevel;
import com.sa.core.models.Log;
import com.sa.core.theme.Theme;
import com.sa.core.writer.strategies.WriterStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Writer {

    Writer setStrategy(WriterStrategy strategy);

    Writer setColorTheme(ColorTheme colorTheme);

    Writer setOutputLevel(OutputLevel outputLevel);

    void write(List<Log> logs);

    Theme getTheme();
    default Map<String, String> useTheme(Log line) {
        HashMap<String, String> themedLog = new HashMap<>();
        Theme theme = this.getTheme();
        themedLog.put(Theme.LEVEL, theme.getLevelColor(line.getLevel()));
        themedLog.put(Theme.DATE_TIME, theme.getDateTime(line.getDateTime()));
        themedLog.put(Theme.MESSAGE, theme.getMessage(line.getMessage()));
        return themedLog;
    }

    ;
}
