package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import page_object.constants_containers.SiteInfoContainer;

public class AttachFileTest extends BaseTest{
    @Test
    public void testAttachFile() throws InterruptedException {
        loginSteps.goToLoginPage()
                .enterLogin(SiteInfoContainer.FIRST_USERNAME)
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD);

    }
}
