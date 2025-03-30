package ru.UI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.UI.helpers.DataTable;
import ru.UI.helpers.FindDeleteCustomer;

import java.util.List;

public class CustomersPage extends BasePage{
    By deleteBtn;
    @FindBy(xpath = "//table[contains(@class, 'table-striped')]")
    WebElement table;
    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customersBtn;
    @FindBy(xpath = "//a[normalize-space()='First Name' and contains(@ng-click, 'fName')]")
    WebElement firstNameBtn;

    public CustomersPage(final WebDriver driver) {
        super(driver);
    }

    @Step("Click a button Delete")
    public void clickDeleteBtn(){
        List<String> customers = DataTable.getColumnData(table);
        deleteBtn = By.xpath(String.format("//tr[td[1]='%s']//button[.='Delete']",
                FindDeleteCustomer.findCustomer(customers)));
        deleteBtn.findElement(driver).click();
    }
    @Step("Click a button Customers")
    public void clickCustomersBtn(){
        customersBtn.click();
    }
    @Step("Double click a button FirstName")
    public void doubleClickFirstNameBtn(){
        firstNameBtn.click();
        firstNameBtn.click();
    }
    public List<String> getArrayValues(){
        return DataTable.getColumnData(table);
    }
}
