package lordmara.magicnumbers;

import lordmara.magicnumbers.controller.Controller;
import lordmara.magicnumbers.controller.ControllerImpl;
import lordmara.magicnumbers.exception.UnsupportedFileTypeException;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReader;
import lordmara.magicnumbers.filereader.FileExtensionAndNameReaderImpl;
import lordmara.magicnumbers.filereader.FileSignatureReader;
import lordmara.magicnumbers.filereader.FileSignatureReaderImpl;
import lordmara.magicnumbers.validator.FileTypeValidator;
import lordmara.magicnumbers.validator.FileTypeValidatorImpl;

import java.io.File;
import java.io.IOException;

public class MagicNumbersApp {
    public static void main(String[] args) throws UnsupportedFileTypeException {
        if(args.length > 0) {
            for(String filePath: args) {
                File file = new File(filePath);
                FileSignatureReader fileSignatureReader = new FileSignatureReaderImpl(file);
                FileExtensionAndNameReader fileExtensionAndNameReader = new FileExtensionAndNameReaderImpl(file);

                try {
                    FileTypeValidator fileTypeValidator = new FileTypeValidatorImpl(fileSignatureReader, fileExtensionAndNameReader);
                    Controller controller = new ControllerImpl(fileTypeValidator);
                    controller.validateFile();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } else {
            System.err.println("File no specified at application start");
        }
    }
}
