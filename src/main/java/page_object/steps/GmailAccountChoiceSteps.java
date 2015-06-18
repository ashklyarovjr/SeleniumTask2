package page_object.steps;

import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.XpathContainer;
import page_object.helpers.CustomWaits;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailLoginPage;

public class GmailAccountChoiceSteps extends AbstractSteps {

    private GmailAccountChoicePage gmailAccountChoicePage;

    private GmailLoginPage loginPage;

    public GmailAccountChoiceSteps(WebDriver driver, GmailAccountChoicePage gmailAccountChoicePage) {
        super(driver);
        this.gmailAccountChoicePage = gmailAccountChoicePage;
    }

    public GmailLoginSteps goToFirstUserAccount() {

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT);

        loginPage = gmailAccountChoicePage.goToFirstUserAccount();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }

    public GmailLoginSteps goToSecondUserAccout() {

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.SECOND_USER_SELECT);

        loginPage = gmailAccountChoicePage.goToSecondUserAccount();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }

    public GmailLoginSteps addAnotherUser() {

        GmailLoginPage loginPage;

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailAccountChoicePageInfo.ADD_ACCOUNT_LINK_XPATH);

        loginPage = gmailAccountChoicePage.addAccount();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }
}
