package lordmara.magicnumbers.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class FileSignatureReaderImpl implements FileSignatureReader {
    private final File file;

    public FileSignatureReaderImpl(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public String readFileSignature(int off, int len) throws IOException {
        try(InputStream inputStream = new FileInputStream(this.file)) {
            byte[] bytes = new byte[len];
            inputStream.read(bytes, off, len);
            return encodeFileSignatureToHexadecimalString(bytes);
        }
    }

    private String encodeFileSignatureToHexadecimalString(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "x", bigInteger).toUpperCase();
    }
}
