package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

public interface FileTypeValidator {
    FileType getFileType();
    FileSignatureReader getFileSignatureReader();
    FileExtensionAndNameReader getFileExtensionAndNameReader();
    boolean validateFile();
}
