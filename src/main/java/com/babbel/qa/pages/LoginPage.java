package com.babbel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//a[@class='cascada-navbar__brand']")
    WebElement loginPageHomeButton;

    @FindBy(xpath = "//h1[contains(text(),'Log in with')]")
    WebElement loginPageTxt;

    public LoginPage() {
        //PageFactory.initElements(driver, this);
    }

    public String getLoginPageTxt() {
        return loginPageTxt.getText();
    }

    public void goToHomePage() {
        loginPageHomeButton.click();
    }


}
