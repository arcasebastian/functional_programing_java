package com.sa.core.functional;

import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface UtilsFunctions {
    static BiFunction<String, String, String> extractString = (line, patternToMatch) -> {
        Pattern pattern = Pattern.compile(patternToMatch, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    };

    Function<String, LocalDateTime> toLocalDateTime = LocalDateTime::parse;

}
