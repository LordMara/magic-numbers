package lordmara.magicnumbers.view;

public interface View {
    void showValidationResult(boolean validationResult, String fileName,
                              String fileExtension, String[] foundTypeExtension);
}
