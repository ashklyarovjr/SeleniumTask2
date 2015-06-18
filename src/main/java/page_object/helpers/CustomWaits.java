package page_object.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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



    public static WebElement waitForElementPresent(WebDriver driver, String elementXpath) {
        return new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .until((WebDriver driver1) -> driver1.findElement(By.xpath(elementXpath)));
    }

    public static WebElement waitForElementClickable(WebDriver driver, String elementXpath) {
        return new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    public static WebElement waitForPresenceOfElementLocated(WebDriver driver, String elementXpath) {
        return new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }








}
