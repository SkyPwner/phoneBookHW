package homework.tests;

import homework.dto.UserInfo;
import homework.utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @BeforeMethod
    public void preconditionsRegistration() {
        app.homePage().clickLoginLink();
        app.homePage().refresh();
        logoutIfLogin();
        app.homePage().clickLoginLink();
    }

    @Test
    public void positiveRegistration() {
        app.loginPage().register();
        app.loginPage().waitForCondition();
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeRegistrationWithEmptyEmail() {
        UserInfo existingUser = new UserInfo("", "12345678Aa$");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    } @Test
    public void negativeRegistrationWithEmptyPassword() {
        UserInfo existingUser = new UserInfo(RandomUtils.randomEmail(), "1234");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    } @Test
    public void negativeRegistrationWithoutSpecialSymbol() {
        UserInfo existingUser = new UserInfo(RandomUtils.randomEmail(), "1234678");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    }

//    @Test
//    public void positiveRegistrationWithLombok() {
//        UserInfoLombok userInfoLombok = UserInfoLombok.builder()
//                .email(RandomUtils.randomEmail())
//                .password("123456Aa$")
//                .build();
//        app.homePage().clickLoginLink();
//        app.loginPage().registerWithLombok(userInfoLombok);
//        app.loginPage().waitForCondition();
//        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
//    }
}
