package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        System.out.println("Connecting to Grid...");
        try {
            ChromeOptions options = new ChromeOptions();
            driver.set(new RemoteWebDriver(
                    new URL("http://192.168.137.130:4444/wd/hub"),
                    options
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
        getDriver().quit();
        driver.remove();
    }
    }
}
