package page_object.constants_containers;


public final class XpathContainer {

    public static final class GmailLoginPageInfo {
        public static final String USERNAME_INPUT_XPATH = "//input[@type='email']";
        public static final String NEXT_BTN_XPATH = "//input[@id='next']";
        public static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
        public static final String SUBMIT_XPATH = "//input[@id='signIn']";
        public static final String ENTER_ANOTHER_ACCOUNT_LINK_XPATH = "//a[@id='account-chooser-link']";
    }

    public static final class GmailAccountChoicePageInfo {
        public static final String ADD_ACCOUNT_LINK_XPATH = "//a[@id='account-chooser-add-account']";
        public static final String FIRST_USER_SELECT = "//button[@value='"+ SiteInfoContainer.FIRST_USERNAME +"']";
        public static final String SECOND_USER_SELECT = "//button[@value='" + SiteInfoContainer.SECOND_USERNAME + "']";
    }

    public static final class GmailMailPageInfo {
        public static final String COMPOSE_BTN_XPATH = "(//div[@id and @class]/div/div[@role='button' and @gh])[2]";
        public static final String FIRST_COMPOSED_LETTER_XPATH = "//tr[1]//span/b[text()='" + SiteInfoContainer.FORM_SUBJ_FIRST + "']";
        public static final String SECOND_COMPOSED_LETTER_XPATH = "//tr[1]//span/b[text()='" + SiteInfoContainer.FORM_SUBJ_SECOND + "']";
        public static final String USER_LOGO_XPATH = "//a[contains(@href, 'SignOutOptions')]";
        public static final String LOGOUT_BTN_XPATH = "//a[contains(@href, 'logout')]";
        public static final String MORE_TABS_BUTTON_XPATH = "//span[@id and @class and @role='button']/span/div";
        public static final String SPAM_TAB_XPATH = "//a[contains(@href, 'spam')]";
        public static final String TO_SPAM_BTN_XPATH = "//div[@class]/div[@act and @role='button'][2]";
        public static final String LAST_RCVD_LETTER_CHECKBOX_XPATH = "(//div[@role='checkbox'])[1]";
        public static final String MAIL_SENT_CONFIRMATION_XPATH = "//div/span[@id='link_vsm']";
        public static final String SPAN_CONFIRMATION_XPATH = "//div[@aria-live]//span[1]";
        public static final String STARRED_TAB_XPATH = "//a[contains(@href, 'starred')]";
        public static final String STARRED_CONFIRMATION_XPATH = "//div[@aria-live]/div/div/span[1]";
        public static final String THEMES_BUTTON_XPATH = "(//div[@data-tooltip-delay])[4]";
        public static final String FIRST_LETTER_ATTACHMENT_ICON_XPATH = "//tbody/tr[@class and @id][1]//img[@class and @alt and @title and @src]";
        public static final String SELECT_ALL_IN_RCVD_TAB = "(//div[@tabindex='0' and @role='button']/div/span)[1]";
        public static final String SELECT_ALL_IN_SPAM_TAB = "//div[@gh]//div[@tabindex='0' and @role='button']/div/span";
        public static final String DELETE_ALL_RCVD_BTN_XPATH = "//div[@class]/div[@act and @role='button'][3]";
        public static final String DELETE_ALL_SPAM_BTN_XPATH = "//div[@act='17']";

    }

    public static final class  GmailComposeMailForm {
        public static final String FORM_XPATH = "//div[@class and @id]/table[@id and @class]";
        public static final String COMPOSE_FORM_TO_XPATH = "//textarea[@name='to']";
        public static final String COMPOSE_FORM_SUBJ_XPATH = "//input[@name='subjectbox']";
        public static final String COMPOSE_FORM_TEXT_XPATH = "//div[@role='textbox' and @contenteditable]";
        public static final String COMPOSE_FORM_SENDBTN_XPATH = "//tbody//div[count(div) = 2]/div[@role='button' and @data-tooltip]";
        public static final String ATTACH_FILE_BUTTON_XPATH = "//div[@command = 'Files']";
    }

    public static final class GmailThemesInfo {
        public static final String THEMES_LIST_XPATH = "//tbody/tr[2]/td/div[@id]/div/div/div/div";
        public static final String THEME_CONFIRMATION_XPATH = "//div[@aria-live and role='alert']/div/div[2]";
    }

}
