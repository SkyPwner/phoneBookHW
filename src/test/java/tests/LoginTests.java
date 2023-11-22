package tests;

import data.DataProviderLogin;
import dto.UserInfoLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @BeforeMethod
    public void preconditionsLogin() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
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