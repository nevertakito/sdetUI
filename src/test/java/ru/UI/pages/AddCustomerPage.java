package ru.UI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends BasePage{
    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement headAddCustomerBtn;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCodeField;
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastNameField;
    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'btn-default')]")
    WebElement addCustomerBtn;

    public AddCustomerPage(final WebDriver driver) {
        super(driver);
    }

    @Step("Click a head button Add Customer")
    public void clickHeadAddCustomerBtn() {
        headAddCustomerBtn.click();
    }
    @Step("Input a Post Code {postCode}")
    public void inputPostCode(String postCode){
        postCodeField.sendKeys(postCode);
    }
    @Step("Input a First Name {firstName}")
    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }
    @Step("Input a Last Name {lastName}")
    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    @Step("Click a button Add Customer")
    public void clickAddCustomerBtn() {
        addCustomerBtn.click();
    }
}