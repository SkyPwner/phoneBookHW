package homework.manager;

import homework.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AboutPage aboutPage;
    private UserProfilePage userProfilePage;
    private AddContactPage addContactPage;


    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        aboutPage = new AboutPage(driver);
        userProfilePage = new UserProfilePage(driver);
        addContactPage = new AddContactPage(driver);
        logger.info("navigated to the url: https://telranedu.web.app/home");
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

    public boolean signedIn = false;

    public void tearDown() {
        driver.quit();
    }
}
