package lordmara.magicnumbers.filereader;

import java.io.File;
import java.io.IOException;

public interface FileSignatureReader {
    File getFile();
    String readFileSignature(int off, int len) throws IOException;
}
