package homework.tests;

import homework.manager.ApplicationManager;
import homework.manager.TestNGListener;
import org.testng.annotations.*;


@Listeners(TestNGListener.class)
public class BaseTest {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

    public void logoutIfLogin() {
        if (app.signedIn){
            app.userProfilePage().clickSignOutButton();
            app.signedIn = false;
        }
    }
}