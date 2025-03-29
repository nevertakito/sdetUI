package ru.UI.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private static final int TIMEOUT = 10;

    /**
     * Метод ожидания появления локаторов
     * @param driver - драйвер
     * @param locator - локатор
     */
    public static void waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
