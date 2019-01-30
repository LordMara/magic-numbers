package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileType;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

import java.io.IOException;
import java.rmi.UnexpectedException;

public class FileTypeValidatorImpl implements FileTypeValidator{
    private final FileSignatureReader signatureReader;
    private final FileExtensionAndNameReader fileExtensionAndNameReader;
    private final FileType fileType;

    public FileTypeValidatorImpl(FileSignatureReader signatureReader,
                                 FileExtensionAndNameReader fileExtensionAndNameReader) throws IOException,
                                                                                               UnsupportedFileType{
        this.signatureReader = signatureReader;
        this.fileExtensionAndNameReader = fileExtensionAndNameReader;
        this.fileType = findFileType();
    }

    private FileType findFileType() throws IOException, UnsupportedFileType{
        try {
            return findFileTypeBySignature();
        } catch (UnsupportedFileType e) {
            if(probeForTextFile()) {
                return FileType.TXT;
            }
            throw new UnsupportedFileType(e.getMessage());
        }
    }

    private FileType findFileTypeBySignature() throws IOException, UnsupportedFileType{
        return null;
    }

    private boolean probeForTextFile() {
        return false;
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
