package com.sa.cli.validators;

import com.beust.jcommander.converters.EnumConverter;
import com.sa.core.enums.Level;

public class LevelFilterConverter extends EnumConverter<Level> {

    public LevelFilterConverter(String optionName, Class<Level> clazz) {
        super(optionName, clazz);
    }
}
