package ru.UI.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.UI.helpers.DriverPool;
import ru.UI.helpers.FindDeleteCustomer;
import ru.UI.pages.CustomersPage;
import ru.UI.helpers.ConfProperties;

import static org.testng.AssertJUnit.assertEquals;

public class DeleteTest {
    public static CustomersPage customersPage;

    @BeforeClass
    private void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        DriverPool.setDriver(driver);
        customersPage = new CustomersPage(driver);

        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("page"));
    }

    @Test
    @Description("Deleting the customer")
    public void deleteTest() {
        customersPage.clickCustomersBtn();
        String customerToRemove = FindDeleteCustomer.findCustomer(customersPage.getArrayValues());
        customersPage.clickDeleteBtn();
        assertEquals(-1,customersPage.getArrayValues().indexOf(customerToRemove));
    }

    @AfterClass
    private void close(){
        DriverPool.quitDriver();
    }
}
