package group.rxcloud.capa.bff.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class ResourceUtils {

    public static byte[] readUrlAsBytes(URL url) throws IOException {
        try (InputStream stream = url.openStream()) {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int len;

            while ((len = stream.read(buffer)) != -1) {
                result.write(buffer, 0, len);
            }

            return result.toByteArray();
        }
    }

    public static String readUrlAsString(URL url) throws IOException {
        return new String(readUrlAsBytes(url));
    }

    public static String readPathAsString(String path) throws IOException {
        URL url = ResourceUtils.class.getResource(path);
        if (url == null) {
            throw new IOException("Resource path not found: " + path);
        }
        return readUrlAsString(url);
    }

    private ResourceUtils() {}
}
