package page_object.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CustomAsserts {

    private static final Logger LOGGER_INFO = Logger.getLogger(CustomAsserts.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(CustomAsserts.class);

    public static void assertThatStringContainsSubstring(String string, String subString) {
        try {
            assertThat(string, containsString(subString));
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in substring search method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertElementsAttributeValue(HtmlElement element, String attribute, String value) {
        try {
            assertThat(element.getAttribute(attribute), is(value));
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertElementsAttributeValue method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertElementAttributeContainsString(HtmlElement element, String attribute, String string) {
        try {
            assertThat(element.getAttribute(attribute), containsString(string));
        } catch (Exception e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertElementAttributeContainsString method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertThatElementIsPresentOnPage(TypifiedElement element) {
        try {
            Assert.assertNotNull(element);
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertThatElementIsPresentOnPage method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertThatElementIsPresentOnPage(HtmlElement element) {
        try {
            Assert.assertNotNull(element);
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertThatElementIsPresentOnPage method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertThatElementIsPresentOnPage(WebElement element) {
        try {
            Assert.assertNotNull(element);
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertThatElementIsPresentOnPage method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertElementsAttributeValue(WebElement element, String attribute, String value) {
        try {
            assertThat(element.getAttribute(attribute), is(value));
        } catch (AssertionError e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertElementsAttributeValue method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void assertElementAttributeContainsString(WebElement element, String attribute, String string) {
        try {
            assertThat(element.getAttribute(attribute), containsString(string));
        } catch (Exception e) {
            LOGGER_ERR.error("CustomAsserts.class. Assertion error in assertElementAttributeContainsString method." + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
