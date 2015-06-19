package base;

import org.testng.annotations.*;
import page_object.steps.GmailLoginSteps;
import webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public GmailLoginSteps loginSteps;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverFactory driverFactory = new WebDriverFactory();

        driver = driverFactory.getDriver("chrome");

        loginSteps = new GmailLoginSteps(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
