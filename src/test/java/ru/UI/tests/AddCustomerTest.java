package ru.UI.tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.UI.helpers.AlertText;
import ru.UI.helpers.DriverPool;
import ru.UI.pages.AddCustomerPage;
import ru.UI.helpers.Generate;

import static org.testng.AssertJUnit.assertEquals;

public class AddCustomerTest extends BaseTest{
    private AddCustomerPage addCustomerPage;
    @BeforeClass
    public final void setup() {
        super.baseSetup();
        addCustomerPage = new AddCustomerPage(DriverPool.getDriver());
    }
    @Test
    @Description("Checking the customers addition")
    public final void addCustomerTest() {
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
    public final void close(){
        DriverPool.getDriver().manage().deleteAllCookies();
        super.baseClose();
    }
}
