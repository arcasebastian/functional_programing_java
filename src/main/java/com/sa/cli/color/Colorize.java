package com.sa.cli.color;

public class Colorize {
    public static String colorize(String line, String color, ColorVariant option) {
        return Color.getVariant(color, option) + line + Color.RESET;
    }

    public static String colorize(String line, String color) {
        return colorize(line, color, ColorVariant.STANDARD);
    }
}
