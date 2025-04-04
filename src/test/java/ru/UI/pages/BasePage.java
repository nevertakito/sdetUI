package ru.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    protected final WebDriver driver;
    public BasePage(final WebDriver webDriver) {
        try {
            this.driver = webDriver;
            PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
