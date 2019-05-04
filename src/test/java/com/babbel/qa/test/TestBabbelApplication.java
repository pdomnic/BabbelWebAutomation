package com.babbel.qa.test;

import com.babbel.qa.base.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/main/java/com/babbel/qa/features", //the path of the feature files
        glue = {"com/babbel/qa/stepdefinition"}, //the path of the step definition files
        dryRun = false,
        plugin = {
                "pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"})
public class TestBabbelApplication extends TestBase {

    private static Logger logger = LoggerFactory.getLogger(TestBabbelApplication.class);


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void setUpClass() {
        logger.info("In Before suite, Initializing the test ng cucumber runner");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    public void beforeTest() {
        logger.info("In before method, initialize the web driver based on the configuration");
        TestBase.initialization();
        TestBase.driver.get(TestBase.url);
    }

    @Test(dataProvider = "features")
    public void feature(final CucumberFeatureWrapper cucumberFeature) {
        logger.info("Starting the feature executing");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() {
        logger.info("Closing the web driver");
        TestBase.driver.quit();
        testNGCucumberRunner.finish();
    }

}
	
