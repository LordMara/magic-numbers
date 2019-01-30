package lordmara.magicnumbers.model;

public enum FileType {
    GIF(new String[]{"GIF"}, 0, new String[]{"474946383761", "474946383961"}),
    JPG(new String[]{"JPG", "JPEG"}, 0, new String[]{"FFD8FF"}),
    TXT(new String[]{"TXT"}, 0, new String[]{"EFBBBF", "FFFE", "FEFF", "FFFE0000", "0000FEFF"});

    private final String[] extensions;
    private final int offset;
    private final String[] hexSignatures;

    FileType(String[] extensions, int offset, String[] hexSignatures) {
        this.extensions = extensions;
        this.offset = offset;
        this.hexSignatures = hexSignatures;
    }

    public String[] getExtensions() {
        return extensions;
    }

    public int getOffset() {
        return offset;
    }

    public String[] getHexSignatures() {
        return hexSignatures;
    }
}
