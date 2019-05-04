package com.babbel.qa.pages;

import com.babbel.qa.base.TestBase;
import com.babbel.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterNewUserPage {

    public static String uName = null;
    @FindBy(xpath = "//h1[contains(text(),'Registration')]")
    WebElement RegistrationTxt;
    @FindBy(xpath = "//button[contains(@class,'dropdown-toggle')]")
    WebElement languageToLearnDropDown;
    @FindBy(xpath = "//p[contains (text(), 'Already a Babbel user')]//preceding-sibling::div//button[contains(text(),'Continue')]")
    WebElement continueAfterLanguageToLearnSelection;
    @FindBy(xpath = "//input[@id='user_firstname']")
    WebElement userFirstName;
    @FindBy(xpath = "//input[@id='user_email']")
    WebElement userEmail;
    @FindBy(xpath = "//div[@class='wizard-step wizard-step-signup-options active']//button[@class='btn btn-primary step-next pull-right'][contains(text(),'Continue')]")
    WebElement continueBtnAfterNameAndEmail;
    @FindBy(xpath = "//input[@id='user_password']")
    WebElement userPassword;
    @FindBy(xpath = "//button[contains(text(),'Confirm registration')]")
    WebElement confirmReg;
    @FindBy(xpath = "//input[@class='btn btn-large']")
    WebElement latterBtn;
    @FindBy(xpath = "//h2[@class='dashboard-sticker__title']")
    WebElement welcomeUserMsg;
    @FindBy(xpath = "//h3[contains(text(),\"Start with Beginner's Course 1, Lesson 1\")]")
    WebElement welcomeCourseMsg;
    @FindBy(xpath = "//a[@class='btn dashboard-sticker__welcome-button']")
    WebElement startLessionBtn;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutBtn;
    @FindBy(xpath = "//a[@class='btn btn-medium btn-block btn-google oauth-provider']")
    WebElement googleBtn;
    @FindBy(xpath = "//div[@class='Fmgc2c']")
    WebElement googleAuthPageTitle;
    @FindBy(xpath = "//a[@class='btn btn-medium btn-block btn-facebook oauth-provider']")
    WebElement facebookBtn;
    @FindBy(xpath = "//span[@class='_50f6']")
    WebElement facebookAuthPageTitle;
    @FindBy(xpath = "//a[@class='cascada-navbar__brand']")
    WebElement homeLink;

    private WebDriver driver;


    public RegisterNewUserPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyRegistrationPageTitle() {
        return driver.getTitle();
    }

    public String verifyRegistrationText() {
        return RegistrationTxt.getText();
    }

    public void selectLanguageToLearn(String language_to_learn) {
        languageToLearnDropDown.click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu inner')]//li//a"));
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getText().contains(language_to_learn)) {
                list.get(i).click();
                break;
            }
    }

    public void clickContineAfterLanguageToLearnSelect() {
        continueAfterLanguageToLearnSelection.click();
    }

    public void enterUserFirstNameAndEmail(String first_name, String email) {
        uName = first_name; // store first name in temp variable. It will be used to logout the session.

        TestBase.waitForElementToBeDisplayed(2000, userFirstName, "FirstName and Email");
        userFirstName.sendKeys(first_name);
        userEmail.sendKeys(TestUtil.getSaltString() + email);
    }

    public void clickContineAfterNameAndEmail() {
        continueBtnAfterNameAndEmail.click();
    }

    public void enterPassword(String password) {
        TestBase.waitForElementToBeDisplayed(2000, userPassword, "Password");
        userPassword.sendKeys(password);
    }

    public void confirmRigistration() {
        confirmReg.click();
    }

    public void emailConfirmation() {
        TestBase.waitForElementToBeDisplayed(10000, latterBtn, "Email Verification Latter button");
        latterBtn.click();
    }

    public String verifyWelcomeUserMsg() {
        TestBase.waitForElementToBeDisplayed(10000, welcomeUserMsg, "Welcome user message in dashboard");
        return welcomeUserMsg.getText();
    }

    public String verifyWelcomeCourseMsg() {
        return welcomeCourseMsg.getText();
    }

    public boolean isStartLessionVisible() {
        return startLessionBtn.isDisplayed();
    }

    public void logOut() {
        WebElement uNameBtn = driver.findElement(By.xpath("//a[contains(text(),'" + uName + "')]"));
        uNameBtn.click();
        logOutBtn.click();
    }

    public void clickGoogleBtn() {
        TestBase.waitForElementToBeDisplayed(10000, googleBtn, "Google Auth Button");
        googleBtn.click();
    }

    public String verifyGoogleAuthPage() {
        TestBase.waitForElementToBeDisplayed(10000, googleAuthPageTitle, "Google Auth Page Title");
        return googleAuthPageTitle.getText();
    }

    public void clickFacebookBtn() {
        TestBase.waitForElementToBeDisplayed(10000, facebookBtn, "Facebook Auth Button");
        facebookBtn.click();
    }

    public String verifyFacebooAuthPage() {
        TestBase.waitForElementToBeDisplayed(10000, facebookAuthPageTitle, "Facebook Auth Page Title");
        return facebookAuthPageTitle.getText();

    }

    public void clickHomeLink() {
        homeLink.click();
        homeLink.click();

    }
}
