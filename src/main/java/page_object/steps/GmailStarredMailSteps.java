package page_object.steps;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailStarredMailPage;

import java.awt.*;
import java.awt.event.KeyEvent;


public class GmailStarredMailSteps extends AbstractSteps {

    GmailStarredMailPage gmailStarredMailPage;

    GmailAccountChoicePage accountChoicePage;

    public GmailStarredMailSteps(WebDriver driver, GmailStarredMailPage gmailStarredMailPage) {
        super(driver);
        this.gmailStarredMailPage = gmailStarredMailPage;
    }

    public GmailStarredMailSteps assertThatFirstMailIsPresent() {
        CustomAsserts.assertThatElementIsPresentOnPage(gmailStarredMailPage.getFirstLetter());
        return this;
    }

    public GmailAccountChoiceSteps logOutFinal() {

        gmailStarredMailPage = gmailStarredMailPage.userLogoClick();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            accountChoicePage = gmailStarredMailPage.logoutBtnClickFinal();

        } catch (UnhandledAlertException e) {
            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT);

        return new GmailAccountChoiceSteps(driver, accountChoicePage);
    }
}
