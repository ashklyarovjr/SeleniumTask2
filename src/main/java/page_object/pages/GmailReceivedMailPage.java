package page_object.pages;



import freemarker.core.TextBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object.base.AbstractPage;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class GmailReceivedMailPage extends AbstractPage {

    public GmailReceivedMailPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @FindBy(xpath = XpathContainer.GmailComposeMailForm.FORM_XPATH)
    private GmailMailForm mailForm;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.COMPOSE_BTN_XPATH)
    private Button composeBtn;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.USER_LOGO_XPATH)
    private Link userLogo;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.LOGOUT_BTN_XPATH)
    private Button logOutBtn;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.LAST_RCVD_LETTER_CHECKBOX_XPATH)
    private CheckBox lastReceivedLetterCheckBox;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.TO_SPAM_BTN_XPATH)
    private Button moveToSpamButton;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.MORE_TABS_BUTTON_XPATH)
    private Link moreTabsLink;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.SPAM_TAB_XPATH)
    private Link spamTabLink;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.MAIL_SENT_CONFIRMATION_XPATH)
    private Link mailSentConfirmationLink;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.SPAN_CONFIRMATION_XPATH)
    private TextBlock spamConfirmationText;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.FIRST_COMPOSED_LETTER_XPATH)
    private Link firstLetterInTheBox;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.STARRED_TAB_XPATH)
    private Link starredTab;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.STARRED_CONFIRMATION_XPATH)
    private TextBlock starredConfirmationText;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.THEMES_BUTTON_XPATH)
    private Button themesButton;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.FIRST_LETTER_ATTACHMENT_ICON_XPATH)
    private Link attachmentIcon;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.SELECT_ALL_IN_RCVD_TAB)
    private CheckBox selectAll;

    @FindBy(xpath = XpathContainer.GmailMailPageInfo.DELETE_ALL_RCVD_BTN_XPATH)
    private Button deleteReceivedLetters;

    public CheckBox getSelectAll() {
        return selectAll;
    }

    public Link getAttachmentIcon() {
        return attachmentIcon;
    }

    public Button getComposeBtn() {
        return composeBtn;
    }

    public CheckBox getLastReceivedLetterCheckBox() {
        return lastReceivedLetterCheckBox;
    }

    public Link getMoreTabsLink() {
        return moreTabsLink;
    }

    public GmailMailForm getMailForm() {
        return mailForm;
    }

    public Link getFirstLetterInTheBox() {
        return firstLetterInTheBox;
    }

    public Link getStarredTab() {
        return starredTab;
    }

    public Button getThemesButton() {
        return themesButton;
    }

    public GmailStarredMailPage goToStarred() {
        starredTab.click();
        return new GmailStarredMailPage(driver);
    }

    public GmailReceivedMailPage userLogoClick() {
        userLogo.click();
        return this;
    }

    public GmailLoginPage logoutBtnClick() {
        logOutBtn.click();
        return new GmailLoginPage(driver);
    }

    public GmailAccountChoicePage logoutBtnClickFinal() {
        logOutBtn.click();
        return new GmailAccountChoicePage(driver);
    }

    public GmailReceivedMailPage selectFirstLetter() {
        lastReceivedLetterCheckBox.select();
        return this;
    }

    public GmailReceivedMailPage moveToSpam() {
        moveToSpamButton.click();
        return this;
    }

    public GmailReceivedMailPage moreTabs() {
        moreTabsLink.click();
        return this;
    }

    public GmailSpamPage goToSpam() {
        spamTabLink.click();
        return new GmailSpamPage(driver);
    }

    public GmailReceivedMailPage composeMail() {
        composeBtn.click();
        return this;
    }

    public GmailReceivedMailPage fillMailAndSend(String email, String subject, String text) throws InterruptedException {
        mailForm.composeMailAndSend(email, subject, text);
        return this;
    }

    public GmailReceivedMailPage fillMailWithAttchAndSend(String email, String subject, String text, String filePath) throws InterruptedException {
        mailForm.composeMailWithAttchAndSend(email, subject, text, filePath);
        return this;
    }

    public GmailThemesPage goToThemes() {
        themesButton.click();
        return new GmailThemesPage(driver);
    }

    public GmailReceivedMailPage selectAllLetters() {
        selectAll.select();
        return this;
    }

    public GmailReceivedMailPage deleteSelectedLetters() {
        deleteReceivedLetters.click();
        return this;
    }



}
