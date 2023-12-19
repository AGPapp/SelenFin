package testframe.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class TestProperties {
    private final Properties properties = new Properties();

    private static TestProperties instance = null;

    private TestProperties(){
        loadProperties();
    }
    public static TestProperties getProperty() {
        if (instance == null) {
            instance = new TestProperties();
        }
        return instance;
    }
    private void loadProperties() {
        try {
            properties.load(new FileInputStream("src/test/resources.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
