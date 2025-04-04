package ru.UI.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.UI.helpers.FindDeleteCustomer;

import static org.testng.AssertJUnit.assertEquals;

public class DeleteTest extends BaseTest {
    @Test
    @Description("Deleting the customer")
    public final void deleteTest() {
        customersPage.clickCustomersBtn();
        String customerToRemove = FindDeleteCustomer.findCustomer(customersPage.getArrayValues());
        customersPage.clickDeleteBtn();
        assertEquals(-1,customersPage.getArrayValues().indexOf(customerToRemove));
    }
}
