package tests;

import data.DataProviderLogin;
import dto.UserInfo;
import dto.UserInfoLombok;
import org.testng.annotations.AfterMethod;
import utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGenerator;

public class RegistrationTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void preconditionsRegistration() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
    }

    @Test(groups = {"smoke"})
    public void positiveRegistration() {
        app.loginPage().register();
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }
    @Test(dataProvider = "loginCSV", dataProviderClass = DataProviderLogin.class)
    public void positiveRegistrationWithDP(UserInfoLombok userInfoLombok) {
        app.loginPage().registerWithLombok(userInfoLombok);
        app.signedIn = true;
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test(groups = {"smoke"})
    public void negativeRegistrationWithEmptyEmail() {
        UserInfo existingUser = new UserInfo("", "12345678Aa$");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    }

    @Test
    public void negativeRegistrationWithEmptyPassword() {
        UserInfo existingUser = new UserInfo(RandomUtils.randomEmail(), "1234");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    }

    @Test
    public void negativeRegistrationWithoutSpecialSymbol() {
        UserInfo existingUser = new UserInfo(RandomUtils.randomEmail(), "1234678");
        app.loginPage().register(existingUser);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageRegistration()));
    }
}
