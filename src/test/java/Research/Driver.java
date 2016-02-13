package Research;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alexander on 02.02.2016.
 */
public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driverInput) {
        driver = driverInput;
    }

    public static void start() {
        Driver.setDriver(new FirefoxDriver());
    }

    public static void finish() {
        Driver.getDriver().quit();
    }
}
