package manager;

import pages.*;
import utils.ConfigProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    static String browser;
    private EventFiringWebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AboutPage aboutPage;
    private UserProfilePage userProfilePage;
    private AddContactPage addContactPage;

    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.CHROME);
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("created chrome browser");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("created fireFox browser");

        }

        driver.navigate().to(ConfigProperties.getProperty("url"));
        logger.info("open page" + ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.register(new WDListener());

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        aboutPage = new AboutPage(driver);
        userProfilePage = new UserProfilePage(driver);
        addContactPage = new AddContactPage(driver);

    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public HomePage homePage() {
        return homePage;
    }

    public AboutPage aboutPage() {
        return aboutPage;
    }

    public UserProfilePage userProfilePage() {
        return userProfilePage;
    }

    public AddContactPage addContactPage() {
        return addContactPage;
    }

    public AddContactPage getAddContactPage() {
        return addContactPage;
    }

    public boolean signedIn = false;

    public void tearDown() {
        driver.quit();
    }
}
