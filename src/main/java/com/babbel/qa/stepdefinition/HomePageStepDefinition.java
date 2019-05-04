package com.babbel.qa.stepdefinition;


import com.babbel.qa.base.TestBase;
import com.babbel.qa.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HomePageStepDefinition {

    private static HomePage homePage;

    public HomePageStepDefinition() {
        homePage = new HomePage(TestBase.driver);
    }

    @Given("^user enter the babbel url$")
    public void user_enter_the_babbel_url() {

    }

    @When("^home page loaded successfully$")
    public void home_page_loaded_successfully() {
        String homePageTitle = homePage.verifyBabbelHomePageTitle();
        Assert.assertEquals("Learn Spanish, French or Other Languages Online - Babbel.com", homePageTitle);
    }

    @Then("^verify all basic elements are displayed$")
    public void verify_all_basic_elements_are_displayed() {
        boolean result = false;
        result = homePage.isBabbelHomeButtonDisplayed();
        Assert.assertTrue(result, "Babbel home button is not visible in home page.");

        result = homePage.isDisplayLanguageDropDownDisplayed();
        Assert.assertTrue(result, "Display Language drop down is not visible in home page.");

        result = homePage.isLogInButtonIsDisplayed();
        Assert.assertTrue(result, "Log in button is not visible in home page.");

        result = homePage.isRegisterButtonIsDisplayed();
        Assert.assertTrue(result, "Register button is not visible in home page.");

        result = homePage.isLearningLanguageDropDownIsDisplayed();
        Assert.assertTrue(result, "Learning Language drop down is not visible in home page.");
    }
	 /*
	 
	 @Then("^verify broken link and image in home page$")
	 public void verify_broken_link_and_image_in_home_page(){
		 
		 //1. Get the list of all Links and Images:
		 List<WebElement> linksList = driver.findElements(By.tagName("a"));
		 linksList.addAll(driver.findElements(By.tagName("img")));
		 
		 List<WebElement> activeLinks = new ArrayList<WebElement>();
		 
		 //2. Iterate linksList
		 for (int i=0; i< linksList.size(); i++){
			 if (linksList.get(i).getAttribute("href")!=null){
				 activeLinks.add(linksList.get(i));
			 }
		 }
		 //3. check the href url with httpconnection api:
		 try {
			 for (int j=0; j< activeLinks.size(); j++) {
				 HttpURLConnection connection =  (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				 connection.connect();
				 connection.getResponseMessage();
				 connection.disconnect();
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 System.out.println("Total Link :" +linksList.size() + "Total active Link :"+activeLinks.size());
	 }	 
	*/


}
