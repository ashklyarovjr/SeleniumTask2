package page_object.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.List;

public class GmailThemesPage extends AbstractPage {
    public GmailThemesPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBys(@FindBy(xpath = XpathContainer.GmailThemesInfo.THEMES_LIST_XPATH))
    private List<Button> themesList;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.USER_LOGO_XPATH)
    private Link userLogo;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH)
    private Button logOutBtn;

    @FindBy(xpath = XpathContainer.GmailThemesInfo.THEME_CONFIRMATION_XPATH)
    private TextBlock themeConfirm;

    public GmailLoginPage logoutBtnClick() {
        logOutBtn.click();
        return new GmailLoginPage(driver);
    }

    public GmailThemesPage userLogoClick() {
        userLogo.click();
        return this;
    }

    public TextBlock getThemeConfirm() {
        return themeConfirm;
    }

    public GmailAccountChoicePage logoutBtnClickFinal() {
        logOutBtn.click();
        return new GmailAccountChoicePage(driver);
    }

    public List<Button> getThemesList() {
        return themesList;
    }
}
