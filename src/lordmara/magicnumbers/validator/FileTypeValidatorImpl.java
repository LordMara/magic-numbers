package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileTypeException;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.model.FileType;

import java.io.IOException;
import java.nio.file.Files;

public class FileTypeValidatorImpl implements FileTypeValidator{
    private final FileSignatureReader fileSignatureReader;
    private final FileExtensionAndNameReader fileExtensionAndNameReader;
    private final FileType fileType;

    public FileTypeValidatorImpl(FileSignatureReader fileSignatureReader,
                                 FileExtensionAndNameReader fileExtensionAndNameReader) throws IOException,
            UnsupportedFileTypeException {
        this.fileSignatureReader = fileSignatureReader;
        this.fileExtensionAndNameReader = fileExtensionAndNameReader;
        this.fileType = findFileType();
    }

    private FileType findFileType() throws IOException, UnsupportedFileTypeException {
        try {
            return findFileTypeBySignature();
        } catch (UnsupportedFileTypeException e) {
            if(probeForTextFile()) {
                return FileType.TXT;
            }
            throw new UnsupportedFileTypeException(e.getMessage());
        }
    }

    private FileType findFileTypeBySignature() throws IOException, UnsupportedFileTypeException {
        for(FileType type: FileType.values()) {
            for(String hexSignature: type.getHexSignatures()) {
                int LENGTH_OF_HEXADECIMAL_NUMBER = 2;
                if(hexSignature.equalsIgnoreCase(fileSignatureReader.readFileSignature(type.getOffset(),
                        hexSignature.length()/LENGTH_OF_HEXADECIMAL_NUMBER))) {
                    return type;
                }
            }
        }
        throw new UnsupportedFileTypeException(String.format("Unsupported file type with extension: %s",
                fileExtensionAndNameReader.getExtension()));
    }

//    need in case of lack of BOM in text file;
    private boolean probeForTextFile() throws IOException{
        return Files.probeContentType(fileExtensionAndNameReader.getFile().toPath()).equals("text/plain");
    }

    @Override
    public FileType getFileType() {
        return this.fileType;
    }

    @Override
    public FileSignatureReader getFileSignatureReader() {
        return this.fileSignatureReader;
    }

    @Override
    public FileExtensionAndNameReader getFileExtensionAndNameReader() {
        return this.fileExtensionAndNameReader;
    }

    @Override
    public boolean validateFile() {
        for(String extension: this.fileType.getExtensions()) {
            if(extension.equalsIgnoreCase(fileExtensionAndNameReader.getExtension())) {
                return true;
            }
        }
        return false;
    }
}
