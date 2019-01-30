package lordmara.magicnumbers.filereader;

import java.io.File;

public class FileExtensionAndNameReaderImpl implements FileExtensionAndNameReader{
    private final File file;
    private final String fileExtension;
    private final String fileName;

    public FileExtensionAndNameReaderImpl(File file) {
        this.file = file;
        this.fileExtension = findFileExtension();
        this.fileName = findFileName();
    }

    private String findFileExtension() {
        return null;
    }

    private String findFileName() {
        return null;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public String getExtension() {
        return this.fileExtension;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
