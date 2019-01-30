package lordmara.magicnumbers.validator;

import lordmara.magicnumbers.exception.UnsupportedFileType;
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
                                                                                               UnsupportedFileType{
        this.fileSignatureReader = fileSignatureReader;
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
        for(FileType type: FileType.values()) {
            for(String hexSignature: type.getHexSignatures()) {
                int LENGTH_OF_HEXDECIMAL_NUMBER = 2;
                if(hexSignature.equalsIgnoreCase(fileSignatureReader.readFileSignature(fileType.getOffset(),
                        hexSignature.length()/LENGTH_OF_HEXDECIMAL_NUMBER))) {
                    return fileType;
                }
            }
        }
        throw new UnsupportedFileType(String.format("Unsupported file type with extension: %s",
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
    public boolean validateFile() throws IOException, UnsupportedFileType {
        for(String extension: this.fileType.getExtensions()) {
            if(extension.equalsIgnoreCase(fileExtensionAndNameReader.getExtension())) {
                return true;
            }
        }
        return false;
    }
}
