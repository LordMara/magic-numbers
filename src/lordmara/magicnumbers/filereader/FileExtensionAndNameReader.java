package lordmara.magicnumbers.filereader;

import java.io.File;

public interface FileExtensionAndNameReader {
    File getFile();
    String getExtension();
    String getFileName();
}
