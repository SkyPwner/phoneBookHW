package tests;

import data.DataProviderLogin;
import dto.UserInfoLombok;
import dto.UserInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @BeforeMethod
    public void preconditionsLogin() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
    }

    @Test
    public void positiveLogin() {
        UserInfo userInfo = new UserInfo("testcaseqwe@mail.ru", "12345678Aa$");
        app.loginPage().login(userInfo);
        app.signedIn = true;
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }

    @Test
    public void negativeLoginWithoutSpecialSymbols() {
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "123456Aa");
        app.loginPage().login(userInfo);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageLogin()));
    }

    @Test
    public void negativeLoginWithoutSymbols() {
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "");
        app.loginPage().login(userInfo);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageLogin()));
    }

    @Test
    public void negativeLoginWithUpperCase() {
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "123456AA$");
        app.loginPage().login(userInfo);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageLogin()));
    }

    @Test(dataProvider = "loginYAML", dataProviderClass = DataProviderLogin.class)
    public void positiveLoginWithDP(UserInfoLombok userInfoLombok) {
        app.loginPage().loginUserInfoLombok(userInfoLombok);
        app.signedIn = true;
        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
    }


    @Test(dataProvider = "negativePasswordDataLogin", dataProviderClass = DataProviderLogin.class)
    public void negativeLoginWithLombok(UserInfoLombok userDP) {
        app.loginPage().loginUserInfoLombok(userDP);
        app.loginPage().waitForAlertAndAccept();
        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageLogin()));
    }
}