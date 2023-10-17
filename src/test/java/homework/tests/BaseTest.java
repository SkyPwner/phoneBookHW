package homework.tests;

import homework.manager.ApplicationManager;
import homework.manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("start test" + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m) {
        logger.info("End of test" + m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
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