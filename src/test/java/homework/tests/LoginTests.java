package homework.tests;

import homework.dto.UserInfo;
import homework.dto.UserInfoLombok;
import homework.dto.UserInfoWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginUserInfo() {
        app.homePage().clickLoginLink();
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "123456Aa$");
        app.loginPage().login(userInfo);
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void positiveLoginUserInfoWith() {
        app.homePage().clickLoginLink();
        UserInfoWith userInfoWith = new UserInfoWith().withEmail("testqa20@gmail.com").withPassword("123456Aa$");
        app.loginPage().login(userInfoWith);
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeLogin() {
        app.homePage().clickLoginLink();
        UserInfo userInfo = new UserInfo("qweasd@gmail.com", "qwe123124123");
        app.loginPage().login(userInfo);
        app.loginPage().waitForAlertAndAccept();

        By errorMessageLocator = By.xpath("//div[text()='Login Failed with code 401']");
        Assert.assertTrue(app.loginPage().isElementDisplayed(errorMessageLocator));
    }

    @Test
    public void positiveLoginWithLombok() {
        UserInfoLombok userInfoLombok = UserInfoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
        app.homePage().clickLoginLink();
        app.loginPage().loginUserInfoLombok(userInfoLombok);
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

}
