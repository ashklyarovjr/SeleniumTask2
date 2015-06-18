package page_object.steps;


import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import page_object.base.AbstractSteps;
import page_object.constants_containers.SiteInfoContainer;
import page_object.constants_containers.XpathContainer;
import page_object.pages.GmailAccountChoicePage;
import page_object.pages.GmailLoginPage;
import page_object.pages.GmailReceivedMailPage;
import page_object.helpers.CustomAsserts;
import page_object.helpers.CustomWaits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GmailLoginSteps extends AbstractSteps {
    GmailLoginPage loginPage;

    GmailReceivedMailPage receivedMailPage;

    GmailAccountChoicePage accountChoicePage;

    public GmailLoginSteps(WebDriver driver) {
        super(driver);
        loginPage = new GmailLoginPage(driver);
    }

    public GmailLoginSteps(WebDriver driver, GmailLoginPage loginPage) {
        super(driver);
        this.loginPage = loginPage;
    }

    public GmailLoginSteps goToLoginPage() {
        loginPage = (GmailLoginPage) loginPage.goToPage();
        CustomWaits.waitForElementPresent(loginPage.getDriver(), XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH);
        return this;
    }

    public GmailLoginSteps enterLogin(String login) {

        loginPage = loginPage.typeUsername(login)
                .nextBtnClick();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH);

        return new GmailLoginSteps(driver, loginPage);
    }

    public GmailAccountChoiceSteps switchToAnotherUser() {

        CustomAsserts.assertThatStringContainsSubstring(loginPage.getTitle(), SiteInfoContainer.LOGIN_PAGE_TITLE_SECOND);

        CustomWaits.waitForPresenceOfElementLocated(driver, XpathContainer.GmailLoginPageInfo.ENTER_ANOTHER_ACCOUNT_LINK_XPATH);

        accountChoicePage = loginPage.enterAnotherAccount();

        return new GmailAccountChoiceSteps(driver, accountChoicePage);
    }

    public GmailReceivedMailSteps enterPassword(String password) {

        receivedMailPage = loginPage.typePassword(password)
                .submitLogin();

        CustomWaits.waitForElementPresent(driver, XpathContainer.GmailMailPageInfo.COMPOSE_BTN_XPATH);

        return new GmailReceivedMailSteps(driver, receivedMailPage);
    }
}
