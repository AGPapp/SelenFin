package testframe.managers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private  WebDriver driver;
    private  static DriverManager instance = null;
    private  final TestProperties properties = TestProperties.getProperty();

    private DriverManager(){}
    public static DriverManager getDriverManager(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }
    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    private void initDriver() {
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //  driver.manage().window().maximize();
        //  driver.get(properties.getProperty("HOSTNAME"));
    }



}
