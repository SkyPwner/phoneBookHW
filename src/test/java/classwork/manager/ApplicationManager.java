package classwork.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    UserPage userPage;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        userPage = new UserPage(driver);
    }

    public UserPage userHelper() {
        return userPage;
    }

    public void tearDown() {
        driver.quit();
    }

}
