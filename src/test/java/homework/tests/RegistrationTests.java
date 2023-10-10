package homework.tests;

import homework.dto.UserInfo;
import homework.dto.UserInfoLombok;
import homework.utils.RandomUtils;
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
        app.loginPage().waitForCondition();
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeRegistration() {
        app.homePage().clickLoginLink();
        UserInfo existingUser = new UserInfo("test@mail.ru", "1234");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessage()));
    }
    @Test
    public void positiveRegistrationWithLombok() {
        UserInfoLombok userInfoLombok = UserInfoLombok.builder()
                .email(RandomUtils.randomEmail())
                .password("123456Aa$")
                .build();
        app.homePage().clickLoginLink();
        app.loginPage().registerWithLombok(userInfoLombok);
        app.loginPage().waitForCondition();
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }
}
