package base;

import page_object.steps.GmailLoginSteps;
import webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public GmailLoginSteps loginSteps;

    @BeforeSuite
    public void setUp() throws Exception {
        WebDriverFactory driverFactory = new WebDriverFactory();

        driver = driverFactory.getDriver("firefox");

        loginSteps = new GmailLoginSteps(driver);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }
}
