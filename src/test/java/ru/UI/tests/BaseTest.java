package ru.UI.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.UI.helpers.ConfProperties;
import ru.UI.helpers.DriverPool;
import ru.UI.pages.CustomersPage;

public class BaseTest {
    protected WebDriver driver;
    protected CustomersPage customersPage;
    @BeforeClass
    void baseSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
        DriverPool.setDriver(driver);
        customersPage = new CustomersPage(DriverPool.getDriver());

        DriverPool.getDriver().manage().window().maximize();
        DriverPool.getDriver().get(ConfProperties.getProperty("page"));
    }
    @AfterClass
    void baseClose() {
        DriverPool.getDriver().manage().deleteAllCookies();
        DriverPool.quitDriver();
    }
}