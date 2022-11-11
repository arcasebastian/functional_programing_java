package com.sa;

import com.beust.jcommander.JCommander;
import com.sa.cli.CLIArguments;
import com.sa.cli.CommanderFunctions;
import com.sa.core.models.Log;
import com.sa.core.reader.Reader;
import com.sa.core.reader.ReaderFactory;
import com.sa.core.writer.WriterFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        JCommander jCommander = CommanderFunctions.buildCommanderWithName("main", CLIArguments::newInstance);

        Stream<CLIArguments> cliArguments = CommanderFunctions.
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(arguments -> (CLIArguments) arguments);

        Optional<CLIArguments> cliOptional = cliArguments
                .filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getFilepath() != null)
                .findFirst();


        if (cliOptional.isPresent()) {
            CLIArguments arguments = cliOptional.get();

            Reader reader = ReaderFactory
                    .getReader("", arguments.getInputFormat())
                    .setFilePath(arguments.getFilepath())
                    .setLogLevel(arguments.getLogLevel());
            List<Log> list = reader.readToList();
            WriterFactory
                    .getWriter("", arguments.getOutputFormat())
                    .setColorTheme(arguments.getColorTheme())
                    .setOutputLevel(arguments.getOutputLevel())
                    .write(list);
        }
    }
}
