package ru.UI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.UI.helpers.DataTable;
import ru.UI.helpers.FindDeleteCustomer;
import ru.UI.helpers.Wait;

import java.util.List;

public class CustomersPage extends BasePage{
    private By deleteBtn;
    private final By customersBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private final By firstNameBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/thead/tr/td[1]/a");
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table")
    WebElement table;

    public CustomersPage(final WebDriver driver) {
        super(driver);
    }

    @Step("Click a button Delete")
    public void clickDeleteBtn(){
        Wait.waitForElement(driver,firstNameBtn);

        List<String> customers = DataTable.getColumnData(table);
        Integer index = customers.indexOf(FindDeleteCustomer.findCustomer(customers))+1;

        deleteBtn = By.xpath(String.format("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[%s]/td[5]/button\n",index));
        deleteBtn.findElement(driver).click();
    }

    @Step("Click a button Customers")
    public void clickCustomersBtn(){
        Wait.waitForElement(driver,customersBtn);
        customersBtn.findElement(driver).click();
    }

    @Step("Double click a button FirstName")
    public void doubleClickFirstNameBtn(){
        Wait.waitForElement(driver,firstNameBtn);
        firstNameBtn.findElement(driver).click();
        firstNameBtn.findElement(driver).click();
    }

    public List<String> getArrayValues(){
        Wait.waitForElement(driver,firstNameBtn);
        return DataTable.getColumnData(table);
    }
}
