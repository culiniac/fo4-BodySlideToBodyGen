package fluxxdog.fo4.convertbodyslide;

import java.nio.file.Files;
import java.nio.file.Paths;

class SlideToGen {
    public static void main(String[] args) throws Exception {
        Arguments arguments = null;
        switch (args.length) {
            case 0:
                showHelp();
                break;
            case 1:
                if (args[0].matches("--?(\\?|h(elp)?)")) {
                    showHelp();
                    break;
                }
                arguments = new Arguments(args[0], "0");
                break;
            default:
                if (!args[1].matches("\\d\\d?")) {
                    showHelp();
                    break;
                }
                arguments = new Arguments(args[0], args[1]);
        }
        assert arguments != null;

        MappedPresets mappedPresets = ProcessSliders.convertToBodyGenTemplates(arguments);
        String outgoingName = arguments.getFile().getName() + ".templates.ini";
        Files.write(Paths.get(outgoingName), mappedPresets.toString().getBytes());
        System.out.println();
    }

    private static void showHelp() {
        System.out.println("usage: filename [variance]\n" +
                "\tfilename - Bodyslide XML to parse\n" +
                "\tvariance - 1 or 2 digit number (percentage) of slider to variate from");
        System.exit(0);
    }
}
