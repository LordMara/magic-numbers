package lordmara.magicnumbers.view;

public class ViewImpl implements View {
    @Override
    public void showValidationResult(boolean validationResult, String fileName,
                                     String fileExtension, String[] foundTypeExtension) {
        if(validationResult) {
            System.out.println(String.format("File: %s is true: .%s", fileName, fileExtension));
        } else {
            System.out.println(String.format("File: %s pretend to be: .%s but for real is: %s",
                    fileName, fileExtension, getPossibleExtensions(foundTypeExtension)));
        }
    }

    private String getPossibleExtensions(String[] foundTypeExtension) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String extension: foundTypeExtension) {
            stringBuilder.append(".");
            stringBuilder.append(extension.toLowerCase());
            stringBuilder.append("/");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("/"));

        return stringBuilder.toString();
    }
}
