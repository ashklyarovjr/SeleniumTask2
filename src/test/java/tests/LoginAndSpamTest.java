package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import page_object.constants_containers.SiteInfoContainer;

public class LoginAndSpamTest extends BaseTest {
    @Test
    public void testLoginAndSpam() {
        loginSteps.goToLoginPage()
                .enterLogin(SiteInfoContainer.FIRST_USERNAME)
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .composeMailAndSend()
                .logOut()
                .switchToAnotherUser()
                .addAnotherUser()
                .enterLogin(SiteInfoContainer.SECOND_USERNAME)
                .enterPassword(SiteInfoContainer.SECOND_PASSWORD)
                .markAsSpam()
                .logOutFinal()
                .goToFirstUserAccount()
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .composeMailAndSend()
                .logOutFinal()
                .goToSecondUserAccout()
                .enterPassword(SiteInfoContainer.SECOND_PASSWORD)
                .goToSpam()
                .assertThatFirstMailIsPresent()
                .logOut();
    }
}
