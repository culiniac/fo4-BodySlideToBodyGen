import java.io.File;

public class SlideToGen {
    public static void main(String... args) {
        Arguments arguments;
        switch (args.length) {
            case 0:
                showHelp();
                break;
            case 1:
                if (args[0].matches("--?(\\?|h(elp)?)")) {
                    showHelp();
                }
                arguments = new Arguments(args[0], "0");
                break;
            default:
                if (!args[1].matches("\\d\\d?")) {
                    throw new IllegalArgumentException("Variance must be a 1 or 2 digit number (percentage)");
                }
                arguments = new Arguments(args[0], args[1]);
        }

        ProcessSliders.convertToBodyGen
    }

    private static void showHelp() {
        System.out.println("usage: filename [variance]\n" +
                "\tfilename - Bodyslide XML to parse\n" +
                "\tvariance - 1 or 2 digit number (percentage) of slider to variate from");
        System.exit(0);
    }
}
