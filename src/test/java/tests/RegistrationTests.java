package tests;

import data.DataProviderLogin;
import dto.UserInfo;
import dto.UserInfoLombok;
import utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void preconditionsRegistration() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
    }

    @Test
    public void positiveRegistration() {
        app.loginPage().register();
        app.signedIn = true;
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }
    @Test(dataProvider = "regYAML", dataProviderClass = DataProviderLogin.class)
    public void positiveRegistrationWithDP(UserInfoLombok userInfoLombok) {
        app.loginPage().registerWithLombok(userInfoLombok);
        app.signedIn = true;
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeRegistrationWithEmptyEmail() {
        UserInfo existingUser = new UserInfo("", "12345678Aa$");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    }
}
