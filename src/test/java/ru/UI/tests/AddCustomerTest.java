package ru.UI.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.UI.helpers.AlertText;
import ru.UI.helpers.ConfProperties;
import ru.UI.helpers.DriverPool;
import ru.UI.pages.AddCustomerPage;
import ru.UI.helpers.Generate;

import static org.testng.AssertJUnit.assertEquals;

public class AddCustomerTest {
    public static AddCustomerPage addCustomerPage;

    @BeforeClass
    private void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        DriverPool.setDriver(driver);
        addCustomerPage = new AddCustomerPage(driver);

        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("page"));
    }

    @Test
    @Description("Checking the customers addition")
    public void addCustomerTest() {
        String code = Generate.generatePostCode();

        addCustomerPage.clickHeadAddCustomerBtn();
        addCustomerPage.inputPostCode(code);
        addCustomerPage.inputFirstName(Generate.generateName(code));
        addCustomerPage.inputLastName("Last");
        addCustomerPage.clickAddCustomerBtn();

        assertEquals("Customer added successfully with customer id :"+AlertText.getCustomerId(DriverPool.getDriver()),
                AlertText.getAlertText(DriverPool.getDriver()));
    }

    @AfterClass
    private void close(){
        DriverPool.quitDriver();
    }
}
