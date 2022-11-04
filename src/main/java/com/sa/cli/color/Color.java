package com.sa.cli.color;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Color {
    public static final String RESET = "\033[0m";
    public static final String BLACK = "BLACK";
    public static final String RED = "RED";
    public static final String GREEN = "GREEN";
    public static final String YELLOW = "YELLOW";
    public static final String BLUE = "BLUE";
    public static final String PURPLE = "PURPLE";
    public static final String CYAN = "CYAN";
    public static final String WHITE = "WHITE";
    private static final HashMap<String, HashMap<ColorVariant, String>> COLOR_VARIANTS = new HashMap<>();

    public static String getVariant(String base, ColorVariant variant) {
        if (COLOR_VARIANTS.isEmpty()) {
            loadVariants();
        }
        return COLOR_VARIANTS.get(base).get(variant);
    }

    private static void loadVariants() {
        List<String> baseColor = List.of(BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE);
        IntStream
                .range(0, baseColor.size())
                .forEach((index) -> {
                    HashMap<ColorVariant, String> colorVariant = new HashMap<>();
                    colorVariant.put(ColorVariant.STANDARD, "\033[0;3" + index + "m");
                    colorVariant.put(ColorVariant.BOLD, "\033[1;3" + index + "m");
                    colorVariant.put(ColorVariant.UNDERLINED, "\033[4;3" + index + "m");
                    colorVariant.put(ColorVariant.BACKGROUND, "\033[4" + index + "m");
                    colorVariant.put(ColorVariant.BRIGHT, "\033[0;9" + index + "m");
                    colorVariant.put(ColorVariant.BOLD_BRIGHT, "\033[1;9" + index + "m");
                    colorVariant.put(ColorVariant.BACKGROUND_BRIGHT, "\033[0;10" + index + "m");
                    COLOR_VARIANTS.put(baseColor.get(index), colorVariant);
                });
    }
}