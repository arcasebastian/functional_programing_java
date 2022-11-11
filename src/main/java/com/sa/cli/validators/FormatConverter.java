package com.sa.cli.validators;

import com.beust.jcommander.converters.EnumConverter;
import com.sa.core.enums.Format;

public class FormatConverter extends EnumConverter<Format> {
    public FormatConverter(String optionName, Class<Format> clazz) {
        super(optionName, clazz);
    }
}
