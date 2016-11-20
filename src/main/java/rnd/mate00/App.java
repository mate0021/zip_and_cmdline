package rnd.mate00;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static CommandLine commandLine;

    public static void main(String[] args) {
        Options options = createOptions();
        parseCommandLineInput(args,options);
    }

    private static Options createOptions() {
        Options result = new Options();
        result.addOption(new Option("f1", true, "First file"));
        result.addOption(new Option("f2", true, "Second file"));
        result.addOption(new Option("c", true, "Columns"));

        return result;
    }

    private static void parseCommandLineInput(String[] args, Options options) {
        CommandLineParser parser = new GnuParser();
        try {
            if (args == null || args.length == 0) {
                printHelp(options);
            }
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            printHelp(options);
        }
    }

    public static List<Integer> getColumns() {
        List<Integer> result = new ArrayList<>();

        if (commandLine.hasOption("c")) {
            String value = commandLine.getOptionValue("c");
            result = Arrays.asList(1, 2, 3);
        }

        return result;
    }

    public static String getPath1() {
        String result = "";
        if (commandLine.hasOption("f1")) {
            result = commandLine.getOptionValue("f1");
        }
        return result;
    }

    public static String getPath2() {
        String result = "";
        if (commandLine.hasOption("f2")) {
            result = commandLine.getOptionValue("f2");
        }
        return result;
    }

    private static void printHelp(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("Call program with following mandatory options", options);
    }
}
