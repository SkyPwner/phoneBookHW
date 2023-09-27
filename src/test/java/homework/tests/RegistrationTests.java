package homework.tests;

import homework.dto.UserInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTests extends BaseTest {

    @Test
    public void positiveRegistration() {
        app.homePage().clickLoginLink();
        app.loginPage().register();
        Wait<WebDriver> wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(2).toMillis());
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeRegistration() {
        app.homePage().clickLoginLink();
        UserInfo existingUser = new UserInfo("test@mail.ru", "1234");
        app.loginPage().register(existingUser);

        Wait<WebDriver> wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(2).toMillis());
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        By errorMessageLocator = By.xpath("//div[text()='Registration failed with code 400']");
        Assert.assertTrue(app.loginPage().isElementDisplayed(errorMessageLocator));
    }
}
