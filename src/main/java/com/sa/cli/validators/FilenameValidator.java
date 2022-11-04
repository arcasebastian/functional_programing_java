package com.sa.cli.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class FilenameValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^.*\\.log$")) {
            System.err.println("El nombre: " + value + " no parece un archivo de log valido.\n");
            throw new ParameterException("Only alphanumerics are supported");
        }
    }
}