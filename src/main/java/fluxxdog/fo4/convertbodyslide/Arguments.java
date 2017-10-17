package fluxxdog.fo4.convertbodyslide;

import java.io.File;

class Arguments {
    private final int variance;
    private final File file;

    Arguments(String filename, String variance) {
        this.file = new File(filename);
        this.variance = Integer.parseInt(variance);
    }

    File getFile() {
        return file;
    }

    int getVariance() {
        return variance;
    }
}
