package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import page_object.constants_containers.SiteInfoContainer;

public class DragNDropTest extends BaseTest {
    @Test
    public void testDragNDrop() throws InterruptedException {
        loginSteps.goToLoginPage()
                .enterLogin(SiteInfoContainer.FIRST_USERNAME)
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .composeMailAndSend()
                .logOut()
                .switchToAnotherUser()
                .addAnotherUser()
                .enterLogin(SiteInfoContainer.SECOND_USERNAME)
                .enterPassword(SiteInfoContainer.SECOND_PASSWORD)
                .dragAndDrop()
                .goToStarred()
                .assertThatFirstMailIsPresent()
                .logOutFinal();
    }
}
