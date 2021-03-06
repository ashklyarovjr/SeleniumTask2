package page_object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;


public class GmailSpamPage extends AbstractPage {

    public GmailSpamPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = XpathContainer.GmailComposeMailForm.FORM_XPATH)
    private GmailMailForm mailForm;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.USER_LOGO_XPATH)
    private Link userLogo;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH)
    private Button logOutBtn;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH)
    private Link firstComposedSpam;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.SECOND_COMPOSED_LETTER_XPATH)
    private Link secondComposedSpam;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.SELECT_ALL_IN_SPAM_TAB)
    private CheckBox selectAll;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.DELETE_ALL_SPAM_BTN_XPATH)
    private Button deleteSpam;

    public Link getFirstComposedSpam() {
        return firstComposedSpam;
    }

    public CheckBox getSelectAll() {
        return selectAll;
    }

    public GmailSpamPage userLogoClick() {
        userLogo.click();
        return this;
    }

    public GmailLoginPage logoutBtnClick() {
        logOutBtn.click();
        return new GmailLoginPage(driver);
    }

    public GmailSpamPage selectAllLetters() {
        selectAll.select();
        return this;
    }

    public GmailSpamPage deleteSelectedLetters() {
        deleteSpam.click();
        return this;
    }
}
