package page_object.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

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
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
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








}
