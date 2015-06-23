package page_object.steps;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailLoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GmailAccountChoiceSteps extends AbstractSteps {

    private GmailAccountChoicePage gmailAccountChoicePage;

    private GmailLoginPage loginPage;

    public GmailAccountChoiceSteps(WebDriver driver, GmailAccountChoicePage gmailAccountChoicePage) {
        super(driver);
        this.gmailAccountChoicePage = gmailAccountChoicePage;
    }

    public GmailLoginSteps goToFirstUserAccount() {

        try {
            CustomWaits.waitFluentForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT);

            loginPage = gmailAccountChoicePage.goToFirstUserAccount();

            CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);
        } catch (UnhandledAlertException e) {
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
            loginPage = gmailAccountChoicePage.goToFirstUserAccount();

            CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);
        }

        return new GmailLoginSteps(driver, loginPage);
    }

    public GmailLoginSteps goToSecondUserAccout() {

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.SECOND_USER_SELECT);

        loginPage = gmailAccountChoicePage.goToSecondUserAccount();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }

    public GmailLoginSteps addAnotherUser() {

        GmailLoginPage loginPage;

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.ADD_ACCOUNT_LINK_XPATH);

        loginPage = gmailAccountChoicePage.addAccount();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }
}
