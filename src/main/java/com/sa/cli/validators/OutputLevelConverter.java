package com.sa.cli.validators;

import com.beust.jcommander.converters.EnumConverter;
import com.sa.core.enums.Format;
import com.sa.core.enums.OutputLevel;

public class OutputLevelConverter extends EnumConverter<OutputLevel> {
    public OutputLevelConverter(String optionName, Class<OutputLevel> clazz) {
        super(optionName, clazz);
    }
}
