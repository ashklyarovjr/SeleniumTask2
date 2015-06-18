package page_object.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.SiteInfoContainer;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;


public class GmailLoginPage extends AbstractPage {

    public GmailLoginPage(WebDriver driver) {
        super(driver, SiteInfoContainer.URL);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = XpathContainer.GmailLoginPageInfo.USERNAME_INPUT_XPATH)
    private TextInput usernameInpt;

    @FindBy(xpath = XpathContainer.GmailLoginPageInfo.PASSWORD_INPUT_XPATH)
    private TextInput passwordInpt;

    @FindBy(xpath = XpathContainer.GmailLoginPageInfo.SUBMIT_XPATH)
    private Button submitBtn;

    @FindBy(xpath = XpathContainer.GmailLoginPageInfo.NEXT_BTN_XPATH)
    private Button nextBtn;

    @FindBy(xpath = XpathContainer.GmailLoginPageInfo.ENTER_ANOTHER_ACCOUNT_LINK_XPATH)
    private Link enterOtherAccountLink;

    public TextInput getUsernameInpt() {
        return usernameInpt;
    }

    public TextInput getPasswordInpt() {
        return passwordInpt;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public Button getNextBtn() {
        return nextBtn;
    }

    public GmailLoginPage nextBtnClick() {
        nextBtn.click();
        return new GmailLoginPage(driver);
    }

    public GmailLoginPage typeUsername(String username) {
        usernameInpt.sendKeys(username);
        return this;
    }

    public GmailLoginPage typePassword(String password) {
        passwordInpt.sendKeys(password);
        return this;
    }

    public GmailReceivedMailPage submitLogin() {
        submitBtn.click();
        return new GmailReceivedMailPage(driver);
    }

    public GmailAccountChoicePage enterAnotherAccount() {
        enterOtherAccountLink.click();
        return new GmailAccountChoicePage(driver);
    }

}
