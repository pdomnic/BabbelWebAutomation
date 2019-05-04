package com.babbel.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//img[@class='logo']")
    WebElement homeButton;

    @FindBy(xpath = "//a[@class='btn btn-inverse']")
    WebElement logInButton;


    @FindBy(xpath = "//span[contains(text(),'Display language:')]")
    WebElement displayLngLabel;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement registerButton;

    @FindBy(xpath = "//a[@class='btn btn--small btn--primary']")
    WebElement registerButton2;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement displayLanguageDropDown;

    @FindBy(xpath = "//a[@class='cascada-dropdown__label cascada-dropdown__label--caret cascada-navbar__item--desktop-only']")
    WebElement displayLanguageDropDown2;


    @FindBy(xpath = "//span[contains(text(),'Help')]")
    WebElement helpButton;

    @FindBy(xpath = "//input[contains(@placeholder,'How can we help?')]")
    WebElement helpText;

    @FindBy(id = "ENG")
    WebElement EngLanguage;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement learningLanguageDropDown;

    private WebDriver driver;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyBabbelHomePageTitle() {
        return driver.getTitle();
    }

    public String verifyDisplayLngLabel() {
        return displayLngLabel.getText();
    }

    public boolean isBabbelHomeButtonDisplayed() {
        return homeButton.isDisplayed();
    }

    public boolean isDisplayLanguageDropDownDisplayed() {
        return displayLanguageDropDown.isDisplayed();
    }

    public boolean isLogInButtonIsDisplayed() {
        return logInButton.isDisplayed();
    }

    public boolean isRegisterButtonIsDisplayed() {
        return registerButton.isDisplayed();
    }

    public boolean isLearningLanguageDropDownIsDisplayed() {
        return logInButton.isDisplayed();
    }

    public void testHelpRequest() {
        driver.switchTo().frame("launcher");
        helpButton.click();
        driver.switchTo().frame("webWidget");
        helpText.sendKeys("What is the display language?");
        helpText.sendKeys(Keys.ENTER);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public void selectDisplayLanguage(String disLanguage) {
        displayLanguageDropDown.click();
        WebElement disLang = driver.findElement(By.id(disLanguage));
        disLang.click();
    }

    public void selectDisplayLanguageFromEng(String disLanguage) {
        displayLanguageDropDown2.click();
        WebElement disLang = driver.findElement(By.id(disLanguage));
        disLang.click();
    }

    public RegisterNewUserPage clickRegisterButton() {
        registerButton2.click();
        return new RegisterNewUserPage(driver);
    }

}
