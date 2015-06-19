package page_object.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class GmailStarredMailPage extends AbstractPage {
    public GmailStarredMailPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.USER_LOGO_XPATH)
    private Link userLogo;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH)
    private Button logOutBtn;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH)
    private Link firstLetter;

    public Link getFirstLetter() {
        return firstLetter;
    }

    public GmailStarredMailPage userLogoClick() {
        userLogo.click();
        return this;
    }

    public GmailAccountChoicePage logoutBtnClickFinal() {
        logOutBtn.click();
        return new GmailAccountChoicePage(driver);
    }
}
