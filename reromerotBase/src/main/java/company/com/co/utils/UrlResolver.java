package company.com.co.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlResolver {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("serenity.properties"));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar serenity.properties", e);
        }
    }

    public static String getUrlFor(String alias) {
        String key = "urls." + alias;
        String url = properties.getProperty(key);

        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("Alias no encontrado: " + alias);
        }

        return url;
    }
}
