package page_object.helpers;


import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CustomWaits {

    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, String elementXpath) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
    }

    public static WebElement waitForVisibilityOf(WebDriver driver, TypifiedElement element) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element.getWrappedElement()));
    }

    public static WebElement waitForPresenceOfElementLocated(WebDriver driver, String elementXpath) {
        WebElement wait = null;
        try {
            wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
        return wait;
    }


    public static void waitFluentForElementClickable(WebDriver driver, String elementXpath) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    public static void waitFluentForPresenceOfElementLocated(WebDriver driver, String elementXpath) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }

    public static void waitFluentForVisibilityOf(WebDriver driver, TypifiedElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
                wait.until(ExpectedConditions.visibilityOf(element.getWrappedElement()));
    }

    public static void delay(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }








}
