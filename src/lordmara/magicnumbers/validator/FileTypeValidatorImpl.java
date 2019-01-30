package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileType;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

import java.io.IOException;

public class FileTypeValidatorImpl implements FileTypeValidator{

    @Override
    public FileType getFileType() {
        return null;
    }

    @Override
    public FileSignatureReader getFileSignatureReader() {
        return null;
    }

    @Override
    public FileExtensionAndNameReader getFileExtensionAndNameReader() {
        return null;
    }

    @Override
    public boolean validateFile() throws IOException, UnsupportedFileType {
        return false;
    }
}
