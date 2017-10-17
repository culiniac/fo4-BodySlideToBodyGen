import java.io.File;

public class Arguments {
    private final int variance;
    private final File file;

    public Arguments(String filename, String variance) {
        this.file = new File(filename);
        this.variance = Integer.parseInt(variance);
    }

    public File getFile() {
        return file;
    }

    public int getVariance() {
        return variance;
    }
}
