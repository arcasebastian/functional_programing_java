package com.sa.cli;

import com.beust.jcommander.Parameter;
import com.sa.cli.validators.*;
import com.sa.core.enums.ColorTheme;
import com.sa.core.enums.Format;
import com.sa.core.enums.Level;
import com.sa.core.enums.OutputLevel;

import java.util.List;

public final class CLIArguments {
    @Parameter(required = true, descriptionKey = "FILEPATH", description = "FILEPATH", validateWith = FilenameValidator.class)
    private String filepath;
    @Parameter(names = "-c", help = true, converter = ColorThemeConverter.class, description = "Coloriza la salida de datos.")
    private ColorTheme colorTheme = ColorTheme.NO_COLOR;
    @Parameter(names = {"--input-format", "-i"}, converter = FormatConverter.class, description = "Define el formato de salida (JSON, Standard)")
    private Format inputFormat = Format.STANDARD;
    @Parameter(names = {"--output-format", "-o"}, converter = FormatConverter.class, description = "Define el formato de salida (JSON, Standard)")
    private Format outputFormat = Format.TABLE;
    @Parameter(names = "--output-level", help = true, converter = OutputLevelConverter.class, description = "Setea la cantidad de información de salida.")
    private OutputLevel outputLevel = OutputLevel.SIMPLE;
    @Parameter(names = {"-f", "--level-filter"}, help = true, converter = LevelFilterConverter.class, description = "Permite remover uno o varios tipos de logs.")
    private List<Level> logLevel;
    @Parameter(names = "--help", help = true, validateWith = HelpValidator.class, description = "Muestra esta ayuda")
    private boolean help;

    CLIArguments() {
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    public String getFilepath() {
        return filepath;
    }

    public Format getInputFormat() {
        return inputFormat;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public Format getOutputFormat() {
        return outputFormat;
    }

    public OutputLevel getOutputLevel() {
        return outputLevel;
    }

    public List<Level> getLogLevel() {
        return logLevel;
    }

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return "CLIArguments{" + "keyword='" + filepath + '\'' + ", pages=" + inputFormat + ", isFullTime=" + outputFormat + ", help=" + help + '}';
    }
}
