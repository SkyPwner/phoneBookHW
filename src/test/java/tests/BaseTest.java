package tests;

import dto.UserInfoLombok;
import manager.ApplicationManager;
import manager.TestNGListener;
import org.testng.annotations.*;


@Listeners(TestNGListener.class)
public class BaseTest {

    protected final ApplicationManager app = new ApplicationManager();
    UserInfoLombok user = UserInfoLombok.builder()
            .email("mytest@mail.ru")
            .password("12345678Aa$")
            .build();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

    public void logoutIfLogin() {
        if (app.signedIn) {
            app.userProfilePage().clickSignOutButton();
            app.signedIn = false;
        }
    }
}