package com.sa.cli.validators;

import com.beust.jcommander.converters.EnumConverter;
import com.sa.core.enums.ColorTheme;

public class ColorThemeConverter extends EnumConverter<ColorTheme> {
    public ColorThemeConverter(String optionName, Class<ColorTheme> clazz) {
        super(optionName, clazz);
    }

    @Override
    public ColorTheme convert(String value) {
        System.out.println(value);
        return super.convert(value);
    }
}
