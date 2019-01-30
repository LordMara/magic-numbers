package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileType;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

import java.io.IOException;

public interface FileTypeValidator {
    FileType getFileType();
    FileSignatureReader getFileSignatureReader();
    FileExtensionAndNameReader getFileExtensionAndNameReader();
    boolean validateFile();
}
