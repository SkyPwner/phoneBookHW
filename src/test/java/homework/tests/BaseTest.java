package homework.tests;

import homework.manager.ApplicationManager;
import homework.manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


@Listeners(TestNGListener.class)
public class BaseTest {
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
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