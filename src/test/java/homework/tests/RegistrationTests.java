package homework.tests;

import homework.dto.UserInfo;
import homework.dto.UserInfoLombok;
import homework.utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
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
