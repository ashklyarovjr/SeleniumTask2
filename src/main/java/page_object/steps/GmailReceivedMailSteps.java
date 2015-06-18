package page_object.steps;


import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.SiteInfoContainer;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailLoginPage;
import page_object.pages.GmailReceivedMailPage;
import page_object.pages.GmailSpamPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GmailReceivedMailSteps extends AbstractSteps {

    GmailReceivedMailPage receivedMailPage;

    GmailLoginPage gmailLoginPage;

    GmailAccountChoicePage accountChoicePage;

    public GmailReceivedMailSteps(WebDriver driver, GmailReceivedMailPage receivedMailPage) {
        super(driver);
        this.receivedMailPage = receivedMailPage;
    }

    public GmailReceivedMailSteps composeMailAndSend() {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getComposeBtn());

        receivedMailPage = receivedMailPage.composeMail();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TO_XPATH);

        receivedMailPage = receivedMailPage.fillMailAndSend(SiteInfoContainer.SECOND_USERNAME, SiteInfoContainer.FORM_SUBJ_FIRST, SiteInfoContainer.FORM_TEXT);

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailMailPageInfo.MAIL_SENT_CONFIRMATION_XPATH);

        return this;
    }

    public GmailReceivedMailSteps markAsSpam() {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getLastReceivedLetterCheckBox());

        receivedMailPage = receivedMailPage.selectFirstLetter();

        CustomWaits.waitForElementClickable(driver, XpathContainer.GmailMailPageInfo.TO_SPAM_BTN_XPATH);

        receivedMailPage = receivedMailPage.moveToSpam();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailMailPageInfo.SPAN_CONFIRMATION_XPATH);

        return this;
    }

    public GmailSpamSteps goToSpam() {

        GmailSpamPage spamPage;

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getMoreTabsLink());

        receivedMailPage = receivedMailPage.moreTabs();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.SPAM_TAB_XPATH);

        spamPage = receivedMailPage.goToSpam();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH);

        return new GmailSpamSteps(driver, spamPage);
    }

    public GmailLoginSteps logOut() {

        receivedMailPage = receivedMailPage.userLogoClick();

        CustomWaits.waitForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            gmailLoginPage = receivedMailPage.logoutBtnClick();

        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH);

        return new GmailLoginSteps(driver, gmailLoginPage);
    }

    public GmailAccountChoiceSteps logOutFinal() {

        receivedMailPage = receivedMailPage.userLogoClick();

        CustomWaits.waitForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            accountChoicePage = receivedMailPage.logoutBtnClickFinal();

        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT);

        return new GmailAccountChoiceSteps(driver, accountChoicePage);
    }
}
