package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import page_object.constants_containers.SiteInfoContainer;

public class LoginAndSpamTest extends BaseTest {
    @Test
    public void testLoginAndSpam() throws InterruptedException {
        loginSteps.goToLoginPage()
                .enterLogin(SiteInfoContainer.FIRST_USERNAME)
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .composeMailAndSend(SiteInfoContainer.SECOND_USERNAME, SiteInfoContainer.FORM_SUBJ_FIRST)
                .logOut()
                .switchToAnotherUser()
                .addAnotherUser()
                .enterLogin(SiteInfoContainer.SECOND_USERNAME)
                .enterPassword(SiteInfoContainer.SECOND_PASSWORD)
                .markAsSpam()
                .logOutFinal()
                .goToFirstUserAccount()
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .composeMailAndSend(SiteInfoContainer.SECOND_USERNAME, SiteInfoContainer.FORM_SUBJ_FIRST)
                .logOutFinal()
                .goToSecondUserAccout()
                .enterPassword(SiteInfoContainer.SECOND_PASSWORD)
                .deleteReceivedMail()
                .goToSpam()
                .assertThatFirstMailIsPresent()
                .deleteSpam()
                .logOut();
    }
}
