package lordmara.magicnumbers.controller;

import lordmara.magicnumbers.exception.UnsupportedFileTypeException;

import java.io.IOException;

public interface Controller {
    void validateFile() throws IOException, UnsupportedFileTypeException;
}
