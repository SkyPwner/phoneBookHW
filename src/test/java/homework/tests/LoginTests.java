package homework.tests;

import homework.dto.UserInfo;
import homework.dto.UserInfoLombok;
import homework.dto.UserInfoWith;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @BeforeMethod
    public void preconditionsRegistration() {
        app.homePage().clickLoginLink();
        app.homePage().refresh();
        logoutIfLogin();
        app.homePage().clickLoginLink();
    }

    @Test
    public void positiveLogin() {
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "123456Aa$");
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

    //    @Test
//    public void negativeLoginClickByXY() {
//        UserInfo userInfo = new UserInfo("qweasd@gmail.com", "qwe123124123");
//        app.loginPage().loginWithClickByXY(userInfo);
//        app.loginPage().waitForAlertAndAccept();
//
//        Assert.assertTrue(app.loginPage().isElementDisplayed(app.loginPage().errorMessageLogin()));
//    }

//    @Test
//    public void positiveLoginWithLombok() {
//        UserInfoLombok userInfoLombok = UserInfoLombok.builder()
//                .email("testqa20@gmail.com")
//                .password("123456Aa$")
//                .build();
//        app.loginPage().loginUserInfoLombok(userInfoLombok);
//        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
//    }

//    @Test
//    public void positiveLoginUserInfoWith() {
//        UserInfoWith userInfoWith = new UserInfoWith().withEmail("testqa20@gmail.com").withPassword("123456Aa$");
//        app.loginPage().login(userInfoWith);
//        Assert.assertTrue(app.userProfilePage().isLoginSuccessful());
//    }
}