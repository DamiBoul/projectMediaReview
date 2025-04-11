package fr.devops.mediareview.config;

import android.content.Context;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ApiConfig {
    private static Properties properties = new Properties();

    public static void init(Context context) {
        try (InputStream input = context.getAssets().open("config.properties")) {
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static String getClientId() {
        return properties.getProperty("api.client_id");
    }

    public static String getAuthorization() {
        return properties.getProperty("api.authorization");
    }
}
