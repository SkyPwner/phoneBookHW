package pages;

import dto.UserInfo;
import dto.UserInfoWith;
import dto.UserInfoLombok;
import utils.RandomUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By emailInput = By.xpath("//input[@name='email']");
    By passwordInput = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@name='login']");
    By registrationButton = By.xpath("//button[@name='registration']");
    By homeLink = By.xpath("//a[@href='/home']");
    By aboutLink = By.xpath("//a[@href='/about']");
    By signOutButton = By.xpath("//button[text()='Sign Out']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(UserInfo UserInfo) {
        type(emailInput, UserInfo.getEmail());
        type(passwordInput, UserInfo.getPassword());
        click(loginButton);

    }

    public void login(UserInfoWith userInfoWith) {
        type(emailInput, userInfoWith.getEmail());
        type(passwordInput, userInfoWith.getPassword());
        click(loginButton);
    }

    public void loginUserInfoLombok(UserInfoLombok user) {
        type(emailInput, user.getEmail());
        type(passwordInput, user.getPassword());
        click(loginButton);
    }

    public void loginWithClickByXY(UserInfo UserInfo) {
        type(emailInput, UserInfo.getEmail());
        type(passwordInput, UserInfo.getPassword());
        clickLoginButtonByCoordinates();
    }

    public void register(UserInfo userInfo) {
        type(emailInput, userInfo.getEmail());
        type(passwordInput, userInfo.getPassword());
        click(registrationButton);
    }

    public void register() {
        type(emailInput, RandomUtils.randomEmail());
        type(passwordInput, RandomUtils.randomPassword());
        click(registrationButton);

    }

    public void registerWithLombok(UserInfoLombok user) {
        type(emailInput, user.getEmail());
        type(passwordInput, user.getPassword());
        click(registrationButton);
    }

    public void clickRegistrationButton() {
        click(registrationButton);
    }

    public void clickHomeLink() {
        click(homeLink);
    }

    public void clickAboutLink() {
        click(aboutLink);
    }

    public void waitForCondition() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2).toMillis());
    }

    public void waitForAlertAndAccept() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2).toMillis());
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickLoginButtonByCoordinates() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).moveByOffset(1, 2).click().perform();
    }

    public By errorMessageRegistration() {
        return By.xpath("//*[contains(text(), 'Registration failed with code')]");
    }

    public By errorMessageLogin() {
        return By.xpath("//*[contains(text(),'Login Failed with code')]");
    }
}
