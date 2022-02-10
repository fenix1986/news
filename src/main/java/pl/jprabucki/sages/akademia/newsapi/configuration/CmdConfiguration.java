package pl.jprabucki.sages.akademia.newsapi.configuration;

import org.apache.commons.cli.*;

public class CmdConfiguration implements Configuration {
    private static final String OPTION_API = "api";
    private static final String OPTION_FILE = "file";

    private static final Options options = new Options();
    private static final CommandLineParser parser = new DefaultParser();

    static {
        Option apiOption = Option.builder()
            .longOpt(OPTION_API)
            .hasArg()
            .required()
            .desc("klucz API")
            .build();

        Option fileOption = Option.builder()
            .longOpt(OPTION_FILE)
            .hasArg()
            .required()
            .desc("nazwa pliku do zapisu wyniku")
            .build();

        options
            .addOption(apiOption)
            .addOption(fileOption);
    }

    private final String[] args;

    public CmdConfiguration(String[] args) {
        this.args = args;
    }

    @Override
    public String getApiKey() throws NoRequiredArgumentException {
        return getOptionValue(OPTION_API);
    }

    @Override
    public String getFileName() throws NoRequiredArgumentException {
        return getOptionValue(OPTION_FILE);
    }

    private String getOptionValue(String option) throws NoRequiredArgumentException {
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar", options, true);
            throw new NoRequiredArgumentException();
        }

        return cmd.getOptionValue(option);
    }
}
