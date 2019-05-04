package com.babbel.qa.base;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 30;
    //public static Properties props;
    public static WebDriver driver;
    public static String url;

    public TestBase() {
        try {
            /*props = new Properties();
            FileInputStream ip = new FileInputStream("config/web_config.properties");
            props.load(ip);*/
            url = System.getenv("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 	WebDriverManager checks the version of the browser installed in your machine (e.g. Chrome, Firefox).
     *	It checks the version of the driver (e.g. chrome driver, firefox driver). If unknown, it uses the latest version of the driver.
     *	It downloads the WebDriver binary if it is not present on the WebDriverManager cache (~/.m2/repository/webdriver by default).
     *	It exports the proper WebDriver Java environment variables required by Selenium
     */

    public static void initialization() {

        if (driver == null) {

            String browserName = System.getenv("browser_name");

            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }

    }

    public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public static void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public static void waitForElementToBeDisplayed(int timeout, WebElement webElement, String webElementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    @SuppressWarnings("unchecked")
    private static void waitUntilCondition(@SuppressWarnings("rawtypes") ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public static void browserNavigateBack() {
        driver.navigate().back();
    }

    public static void browserNavigateForward() {
        driver.navigate().forward();
    }

    public static void browserNavigateTo(String appUrl) {
        driver.navigate().to(appUrl);
    }

    public static void browserRefresh() {
        driver.navigate().refresh();
        ;
    }

    public void SelectByIndex(WebElement element, int index) {
        Select s = new Select(element);
        s.selectByIndex(index);
    }

    public void selectbyvisibletext(WebElement element, String name) {
        Select s = new Select(element);
        s.selectByVisibleText(name);
    }

}    
