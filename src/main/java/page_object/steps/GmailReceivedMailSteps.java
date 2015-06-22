package page_object.steps;


import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page_object.base.AbstractSteps;
import page_object.constants_containers.SiteInfoContainer;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;
import page_object.pages.*;

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

    public GmailReceivedMailSteps composeMailAndSend(String username, String subject) throws InterruptedException {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getComposeBtn());

        receivedMailPage = receivedMailPage.composeMail();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TO_XPATH);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.ATTACH_FILE_BUTTON_XPATH);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.COMPOSE_FORM_SENDBTN_XPATH);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TEXT_XPATH);

        receivedMailPage = receivedMailPage.fillMailAndSend(username, subject, SiteInfoContainer.FORM_TEXT);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.MAIL_SENT_CONFIRMATION_XPATH);

        return this;
    }

    public GmailReceivedMailSteps composeMailWithAttachAndSend() throws InterruptedException {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getComposeBtn());

        receivedMailPage = receivedMailPage.composeMail();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TO_XPATH);

        CustomWaits.waitForVisibilityOf(driver, receivedMailPage.getMailForm().getAttachFileBtn());

        CustomWaits.waitForVisibilityOf(driver, receivedMailPage.getMailForm().getSendBtn());

        CustomWaits.waitForVisibilityOf(driver, receivedMailPage.getMailForm().getTextField());

        receivedMailPage = receivedMailPage.fillMailWithAttchAndSend(SiteInfoContainer.SECOND_USERNAME, SiteInfoContainer.FORM_SUBJ_FIRST, SiteInfoContainer.FORM_TEXT, SiteInfoContainer.FILE_PATH);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.MAIL_SENT_CONFIRMATION_XPATH);

        return this;
    }

    public GmailReceivedMailSteps markAsSpam() {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getLastReceivedLetterCheckBox());

        receivedMailPage = receivedMailPage.selectFirstLetter();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.TO_SPAM_BTN_XPATH);

        receivedMailPage = receivedMailPage.moveToSpam();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.SPAN_CONFIRMATION_XPATH);

        return this;
    }

    public GmailSpamSteps goToSpam() {

        GmailSpamPage spamPage;

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getMoreTabsLink());

        receivedMailPage = receivedMailPage.moreTabs();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.SPAM_TAB_XPATH);

        spamPage = receivedMailPage.goToSpam();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH);

        return new GmailSpamSteps(driver, spamPage);
    }

    public GmailLoginSteps logOut() {

        receivedMailPage = receivedMailPage.userLogoClick();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            gmailLoginPage = receivedMailPage.logoutBtnClick();

            CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH);

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

    public GmailAccountChoiceSteps logOutFinal() {

        receivedMailPage = receivedMailPage.userLogoClick();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            accountChoicePage = receivedMailPage.logoutBtnClickFinal();

            CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT);

        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }

        return new GmailAccountChoiceSteps(driver, accountChoicePage);
    }

    public GmailStarredMailSteps goToStarred() {

        GmailStarredMailPage starredMailPage;

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getStarredTab());

        starredMailPage = receivedMailPage.goToStarred();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH);

        return new GmailStarredMailSteps(driver, starredMailPage);
    }

    public GmailReceivedMailSteps dragAndDrop() {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getStarredTab());

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH);

        Actions actions = new Actions(driver);

        actions.dragAndDrop(receivedMailPage.getFirstLetterInTheBox().getWrappedElement(), receivedMailPage.getStarredTab().getWrappedElement()).build().perform();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailMailPageInfo.STARRED_CONFIRMATION_XPATH);

        return this;
    }

    public GmailReceivedMailSteps assertThatFirstMailIsPresent() {

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getFirstLetterInTheBox());

        return this;
    }

    public GmailThemesSteps goToThemes() {

        GmailThemesPage themesPage;

        CustomAsserts.assertThatElementIsPresentOnPage(receivedMailPage.getThemesButton());

        themesPage = receivedMailPage.goToThemes();

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailThemesInfo.THEMES_LIST_XPATH);

        return new GmailThemesSteps(driver, themesPage);
    }
}
