package com.babbel.qa.stepdefinition;

import com.babbel.qa.base.TestBase;
import com.babbel.qa.pages.HomePage;
import com.babbel.qa.pages.RegisterNewUserPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class RegisterUserWithGoogleOrFB {

    private static RegisterNewUserPage registerNewUserPage;
    private static HomePage homePage;

    public RegisterUserWithGoogleOrFB() {
        homePage = new HomePage(TestBase.driver);
        registerNewUserPage = new RegisterNewUserPage(TestBase.driver);
    }

    @Given("^enter the babbel url$")
    public void enter_the_babbel_url() {

    }

    @Then("^click register button$")
    public void click_register_button() {
        homePage.clickRegisterButton();
    }

    @Then("^select language to learn \"(.*)\"$")
    public void select_language_to_learn(String language_to_learn) {
        registerNewUserPage.selectLanguageToLearn(language_to_learn);
    }

    @Then("^click continue button after language to learn select$")
    public void click_continue_button_after_language_to_learn_select() {
        registerNewUserPage.clickContineAfterLanguageToLearnSelect();
    }

    @Then("^click auth provider \"(.*)\"$")
    public void click_auth_provider(String auth_provider) throws InterruptedException {
        if (auth_provider.equals("google")) {
            registerNewUserPage.clickGoogleBtn();
            String googleAuthPageTitle = registerNewUserPage.verifyGoogleAuthPage();
            Assert.assertTrue(googleAuthPageTitle.contains("Google"));
            TestBase.browserNavigateBack();
            registerNewUserPage.clickHomeLink();
        } else if (auth_provider.equals("facebook")) {
            registerNewUserPage.clickFacebookBtn();
            String facebookAuthPageTitle = registerNewUserPage.verifyFacebooAuthPage();
            Assert.assertTrue(facebookAuthPageTitle.contains("Facebook"), "Page forwarding to Facebook Login failed");
            TestBase.browserNavigateBack();
            registerNewUserPage.clickHomeLink();
        }

    }
}
