package page_object.steps;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailLoginPage;
import page_object.pages.GmailThemesPage;
import ru.yandex.qatools.htmlelements.element.Button;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;


public class GmailThemesSteps extends AbstractSteps {

    GmailThemesPage themesPage;

    GmailAccountChoicePage accountChoicePage;

    public GmailThemesSteps(WebDriver driver, GmailThemesPage themesPage) {
        super(driver);
        this.themesPage = themesPage;
    }

    public GmailThemesSteps chooseRandomTheme() {

        Random random = new Random(themesPage.getThemesList().size());

        List<Button> themes = themesPage.getThemesList();

        int randomNum = random.nextInt(themes.size() + 1);

        themes.get(randomNum).click();

        CustomAsserts.assertThatElementIsPresentOnPage(themesPage.getThemeConfirm());

        return this;
    }

    public GmailLoginSteps logOut() {

        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);

        themesPage = themesPage.userLogoClick();

        CustomWaits.waitFluentForElementClickable(driver, XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH);

        try {

            themesPage.logoutBtnClick();

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


}
