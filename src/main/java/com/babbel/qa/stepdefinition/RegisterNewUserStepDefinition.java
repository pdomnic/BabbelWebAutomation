package com.babbel.qa.stepdefinition;

import com.babbel.qa.base.TestBase;
import com.babbel.qa.pages.HomePage;
import com.babbel.qa.pages.RegisterNewUserPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RegisterNewUserStepDefinition {

    public static String signUpUserName = null;

    private static RegisterNewUserPage registerNewUserPage;
    private static HomePage homePage;

    public RegisterNewUserStepDefinition() {
        homePage = new HomePage(TestBase.driver);
        registerNewUserPage = new RegisterNewUserPage(TestBase.driver);
    }

    @Given("^user is already in home page$")
    public void user_is_already_in_home_page() {
        String homePageTitle = homePage.verifyBabbelHomePageTitle();
        Assert.assertTrue(homePageTitle.contains("Babbel"), "Home Page title is not correct.");
    }

    @When("^user select display language \"(.*)\"$")
    public void user_select_display_language(String display_language) {
        homePage.selectDisplayLanguage(display_language);
    }

    @Then("^user click register button$")
    public void user_click_register_button() {
        homePage.clickRegisterButton();
    }

    @Then("^user select language to learn \"(.*)\"$")
    public void user_select_language_to_learn(String language_to_learn) {
        registerNewUserPage.selectLanguageToLearn(language_to_learn);
    }

    @Then("^user click continue button after language to learn select$")
    public void user_click_continue_button_after_language_to_learn_select() {
        registerNewUserPage.clickContineAfterLanguageToLearnSelect();
    }

    @Then("^user enter \"(.*)\" and \"(.*)\"$")
    public void user_enter_first_name_and_email(String first_name, String email) throws InterruptedException {
        signUpUserName = first_name;
        registerNewUserPage.enterUserFirstNameAndEmail(first_name, email);

    }

    @Then("^user click continue button$")
    public void user_click_continue_button() throws InterruptedException {
        registerNewUserPage.clickContineAfterNameAndEmail();
    }

    @Then("^user enter password \"(.*)\"$")
    public void user_enter_password(String password) throws InterruptedException {
        registerNewUserPage.enterPassword(password);
    }

    @Then("^user click confirm registration$")
    public void user_click_confirm_registration() {
        registerNewUserPage.confirmRigistration();
    }

    @Then("^user click latter email confirmation$")
    public void user_click_latter_email_confirmation() throws InterruptedException {
        registerNewUserPage.emailConfirmation();
    }

    @Then("^verify user welcome dashboard message$")
    public void verify_user_welcome_dashboard_message() throws InterruptedException {
        String welcomeMsg = registerNewUserPage.verifyWelcomeUserMsg();
        Assert.assertEquals("Welcome " + signUpUserName + "!", welcomeMsg, "User welcome message is not correct.");
    }

    @Then("^verify welcome course dashboard message$")
    public void verify_welcome_course_dashboard_message() {
        String welcomeCourseMsg = registerNewUserPage.verifyWelcomeCourseMsg();
        Assert.assertEquals("Start with Beginner's Course 1, Lesson 1", welcomeCourseMsg, "Welcome course message is not correct.");
    }

    @Then("^check start lession is visible$")
    public void check_start_lession_is_visible() {
        Assert.assertTrue(registerNewUserPage.isStartLessionVisible(), "Start Lession is not visible.");
    }

    @Then("^user log out from the session$")
    public void user_log_out_from_the_session() {
        registerNewUserPage.logOut();
    }


}
