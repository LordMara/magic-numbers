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
        if(this.file != null && this.file.exists()) {
            String fileName = file.getName();
//            add 1 to index because we are interested only in extension without dot
            int CORRECTION_OF_INDEX = 1;
            return fileName.substring(fileName.lastIndexOf(".") + CORRECTION_OF_INDEX);
        }
        return "";
    }

    private String findFileName() {
        if(this.file != null && this.file.exists()) {
            return this.file.getName();
        }
        return "";
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
