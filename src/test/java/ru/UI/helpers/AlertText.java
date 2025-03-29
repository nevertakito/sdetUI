package ru.UI.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertText {
    public static String getAlertText(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    public static String getCustomerId(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert.getText().substring(alert.getText().length()-1);
    }
}