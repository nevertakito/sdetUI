package ru.UI.helpers;

import org.openqa.selenium.WebDriver;

public class DriverPool {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void setDriver(WebDriver newDriver) {
        driver.set(newDriver);
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
