package page_object.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.SiteInfoContainer;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class GmailAccountChoicePage extends AbstractPage{

    public GmailAccountChoicePage(WebDriver driver) {
        super(driver, SiteInfoContainer.URL);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = XpathContainer.GmailAccountChoicePageInfo.FIRST_USER_SELECT)
    private Button firstUserAccount;

    @FindBy(xpath = XpathContainer.GmailAccountChoicePageInfo.SECOND_USER_SELECT)
    private Button secondUserAccount;

    @FindBy(xpath = XpathContainer.GmailAccountChoicePageInfo.ADD_ACCOUNT_LINK_XPATH)
    private Link addAccountLink;

    public GmailLoginPage goToFirstUserAccount() {
        firstUserAccount.click();
        return new GmailLoginPage(driver);
    }

    public GmailLoginPage goToSecondUserAccount() {
        secondUserAccount.click();
        return new GmailLoginPage(driver);
    }

    public GmailLoginPage addAccount() {
        addAccountLink.click();
        return new GmailLoginPage(driver);
    }

}
