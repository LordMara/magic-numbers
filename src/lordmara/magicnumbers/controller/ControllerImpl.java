package lordmara.magicnumbers.controller;

import lordmara.magicnumbers.exception.UnsupportedFileTypeException;
import lordmara.magicnumbers.validator.FileTypeValidator;
import lordmara.magicnumbers.view.View;

import java.io.IOException;

public class ControllerImpl implements Controller {
    private View view;
    private FileTypeValidator fileTypeValidator;

    public ControllerImpl(View view, FileTypeValidator fileTypeValidator) {
        this.view = view;
        this.fileTypeValidator = fileTypeValidator;
    }

    @Override
    public void validateFile() throws IOException, UnsupportedFileTypeException {
        view.showValidationResult(fileTypeValidator.validateFile(),
                fileTypeValidator.getFileExtensionAndNameReader().getFileName(),
                fileTypeValidator.getFileExtensionAndNameReader().getExtension(),
                fileTypeValidator.getFileType().getExtensions());
    }
}
