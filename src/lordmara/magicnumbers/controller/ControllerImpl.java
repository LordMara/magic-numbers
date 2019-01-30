package lordmara.magicnumbers.controller;

import lordmara.magicnumbers.exception.UnsupportedFileTypeException;
import lordmara.magicnumbers.validator.FileTypeValidator;

import java.io.IOException;

public class ControllerImpl implements Controller {
    private FileTypeValidator fileTypeValidator;

    public ControllerImpl(FileTypeValidator fileTypeValidator) {
        this.fileTypeValidator = fileTypeValidator;
    }

    @Override
    public void validateFile() throws IOException, UnsupportedFileTypeException {
//        if true file dont lie about extension
        System.out.println(fileTypeValidator.validateFile());
    }
}
