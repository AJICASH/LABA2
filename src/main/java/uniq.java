import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class uniq {
    @Option(name = "-i", usage = "Flag -i says that register doesn't matter")
    private boolean TheRegisterDoesNotMakeSense;
    @Option(name = "-u", usage = "Flag -u says that only unique strings should be written")
    private boolean OnlyUniqueStr;
    @Option(name = "-c", usage = "Flag -c says that before strings that are duplicated should be written " +
            "number of repeating strings")
    private boolean Prefix;
    @Option(name = "-s", usage = "the -s flag means that when detecting lines, the first N" +
            " should be ignored characters of each line.")
    private int num;

    @Option(name = "-o", usage = "name of output file")
    private String OutFile;
    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) throws IOException, CmdLineException {
        new uniq().parse(args);
    }
    private void parse(String[] args) throws IOException, CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.print("invalid input - ");
            System.err.println(e.getMessage());
            throw e;
        }
    }

}