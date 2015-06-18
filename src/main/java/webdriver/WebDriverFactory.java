package webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver(String parameter) {
        switch (parameter) {
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                return driver;
            case "ie":
                System.setProperty("webdriver.ie.driver", "..\\SeleniumTask3\\WebDrivers\\IEDriverServer32.exe");
                driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                return driver;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "..\\SeleniumTask3\\WebDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
                return driver;
            default:
                throw new IllegalArgumentException("This browser is undefined!");
        }
    }
}
