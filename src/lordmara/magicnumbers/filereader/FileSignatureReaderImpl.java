package lordmara.magicnumbers.filereader;

import java.io.File;
import java.io.IOException;

public class FileSignatureReaderImpl implements FileSignatureReader {
    private final File file;

    public FileSignatureReaderImpl(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public String readFileSignature(int off, int len) throws IOException {
        return null;
    }
}
