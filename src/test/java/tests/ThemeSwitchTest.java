package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import page_object.constants_containers.SiteInfoContainer;


public class ThemeSwitchTest extends BaseTest {
    @Test
    public void testThemesSwitch() throws InterruptedException {
        loginSteps.goToLoginPage()
                .enterLogin(SiteInfoContainer.FIRST_USERNAME)
                .enterPassword(SiteInfoContainer.FIRST_PASSWORD)
                .goToThemes()
                .chooseRandomTheme()
                .logOut();

    }
}
