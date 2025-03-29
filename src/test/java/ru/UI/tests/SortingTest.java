package ru.UI.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.UI.helpers.DriverPool;
import ru.UI.pages.CustomersPage;
import ru.UI.helpers.ConfProperties;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SortingTest {
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
    @Description("Sorting the customers")
    public void sortingTest() {
        customersPage.clickCustomersBtn();
        List<String> list = customersPage.getArrayValues()
                .stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
        customersPage.doubleClickFirstNameBtn();
        List<String> sortedList = customersPage.getArrayValues();
        assertEquals(list, sortedList);
    }

    @AfterClass
    private void close(){
        DriverPool.quitDriver();
    }
}
