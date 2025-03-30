package ru.UI.tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.UI.helpers.DriverPool;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SortingTest extends BaseTest{
    @Test
    @Description("Sorting the customers")
    public final void sortingTest() {

        customersPage.clickCustomersBtn();
        List<String> list = customersPage.getArrayValues()
                .stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
        customersPage.doubleClickFirstNameBtn();
        List<String> sortedList = customersPage.getArrayValues();
        assertEquals(list, sortedList);
    }
    @AfterMethod
    public final void deleteCookies(){
        DriverPool.getDriver().manage().deleteAllCookies();
    }
}