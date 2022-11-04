package com.sa.cli;

import com.beust.jcommander.Parameter;
import com.sa.cli.validators.FilenameValidator;
import com.sa.cli.validators.HelpValidator;
import com.sa.cli.validators.LevelFilterConverter;
import com.sa.core.log.Level;

import java.util.List;

public final class CLIArguments {
    @Parameter(
            required = true,
            descriptionKey = "FILEPATH",
            description = "FILEPATH",
            validateWith = FilenameValidator.class)
    private String filepath;
    @Parameter(
            names = {"--input-format", "-i"},
            description = "Define el formato de salida (JSON, Standard)")
    private String inputFormat = "standard";
    @Parameter(
            names = {"--output-format", "-o"},
            description = "Define el formato de salida (JSON, Standard)"
    )
    private String outputFormat = "standard";
    @Parameter(
            names = {"-f", "--level-filter"},
            help = true,
            converter = LevelFilterConverter.class,
            description = "Permite remover uno o varios tipos de logs.")
    private List<Level> logLevel;
    @Parameter(
            names = "--help",
            help = true,
            validateWith = HelpValidator.class,
            description = "Muestra esta ayuda")
    private boolean help;
    CLIArguments() {
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    public String getFilepath() {
        return filepath;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public List<Level> getLogLevel() {
        return logLevel;
    }

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + filepath + '\'' +
                ", pages=" + inputFormat +
                ", isFullTime=" + outputFormat +
                ", help=" + help +
                '}';
    }
}
