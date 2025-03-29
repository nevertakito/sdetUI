package ru.UI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.UI.helpers.Wait;

import static org.testng.AssertJUnit.assertEquals;

public class AddCustomerPage extends BasePage{
    private final String headAddCustomerBtnXPath = "/html/body/div/div/div[2]/div/div[1]/button[1]";
    private final String postCodeFieldXPath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input";
    private final String firstNameFieldXPath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input\n";
    private final String lastNameFieldXPath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input";
    private final String addCustomerBtnXPath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button";
    private final By headAddCustomerBtnBy = By.xpath(headAddCustomerBtnXPath);
    private final By postCodeFieldBy = By.xpath(postCodeFieldXPath);
    private final By firstNameFieldBy = By.xpath(firstNameFieldXPath);
    private final By lastNameFieldBy = By.xpath(lastNameFieldXPath);
    private final By addCustomerBtnBy = By.xpath(addCustomerBtnXPath);
    @FindBy(xpath = headAddCustomerBtnXPath)
    private WebElement headAddCustomerBtn;
    @FindBy(xpath = postCodeFieldXPath)
    private WebElement postCodeField;
    @FindBy(xpath = firstNameFieldXPath)
    private WebElement firstNameField;
    @FindBy(xpath = lastNameFieldXPath)
    private WebElement lastNameField;
    @FindBy(xpath = addCustomerBtnXPath)
    private WebElement addCustomerBtn;

    public AddCustomerPage(final WebDriver driver) {
        super(driver);
    }

    @Step("Click a head button Add Customer")
    public void clickHeadAddCustomerBtn() {
        Wait.waitForElement(driver,headAddCustomerBtnBy);
        headAddCustomerBtn.click();
    }

    @Step("Input a Post Code {postCode}")
    public void inputPostCode(String postCode){
        Wait.waitForElement(driver,postCodeFieldBy);
        postCodeField.sendKeys(postCode);
    }

    @Step("Input a First Name {firstName}")
    public void inputFirstName(String firstName){
        Wait.waitForElement(driver,firstNameFieldBy);
        firstNameField.sendKeys(firstName);
    }

    @Step("Input a Last Name {lastName}")
    public void inputLastName(String lastName){
        Wait.waitForElement(driver,lastNameFieldBy);
        lastNameField.sendKeys(lastName);
    }

    @Step("Click a button Add Customer")
    public void clickAddCustomerBtn() {
        Wait.waitForElement(driver,addCustomerBtnBy);
        addCustomerBtn.click();
    }
}