package company.com.co.resolvers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlResolver {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("serenity.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("❌ No se pudo cargar serenity.properties", e);
        }
    }

    public static String getUrlFor(String alias) {
        if (alias == null || alias.trim().isEmpty()) {
            throw new IllegalArgumentException("⚠️ El alias no puede ser nulo o vacío.");
        }

        String key = "urls." + alias.toLowerCase();
        String url = properties.getProperty(key);

        if (url != null && !url.trim().isEmpty()) {
            return url;
        }

        throw new IllegalArgumentException("❌ Alias no encontrado: " + alias + ". Verifica serenity.properties o fallback.");
    }
}
