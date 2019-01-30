package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileType;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

import java.io.IOException;

public class FileTypeValidatorImpl implements FileTypeValidator{
    private final FileSignatureReader signatureReader;
    private final FileExtensionAndNameReader fileExtensionAndNameReader;
    private final FileType fileType;

    public FileTypeValidatorImpl(FileSignatureReader signatureReader, FileExtensionAndNameReader fileExtensionAndNameReader) {
        this.signatureReader = signatureReader;
        this.fileExtensionAndNameReader = fileExtensionAndNameReader;
        this.fileType = findFileType();
    }

    private FileType findFileType() {
        return  null;
    }

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
