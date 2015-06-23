package page_object.steps;


import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailLoginPage;
import page_object.pages.GmailSpamPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GmailSpamSteps extends AbstractSteps {

    GmailSpamPage gmailSpamPage;

    public GmailSpamSteps(WebDriver driver, GmailSpamPage gmailSpamPage) {
        super(driver);
        this.gmailSpamPage = gmailSpamPage;
    }

    public GmailLoginSteps logOut() {

        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);

        gmailSpamPage = gmailSpamPage.userLogoClick();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            gmailSpamPage.logoutBtnClick();

        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }

        return new GmailLoginSteps(driver, gmailLoginPage);
    }

    public GmailSpamSteps assertThatFirstMailIsPresent() {
        CustomAsserts.assertThatElementIsPresentOnPage(gmailSpamPage.getFirstComposedSpam());
        return this;
    }

    public GmailSpamSteps deleteSpam() {

        CustomAsserts.assertThatElementIsPresentOnPage(gmailSpamPage.getSelectAll());

        gmailSpamPage = gmailSpamPage.selectAllLetters();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.DELETE_ALL_SPAM_BTN_XPATH);

        gmailSpamPage = gmailSpamPage.deleteSelectedLetters();

        return this;
    }
}
