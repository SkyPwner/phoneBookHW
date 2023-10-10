package homework.pages;

import homework.dto.UserInfoLombok;
import homework.dto.UserInfoWith;
import homework.utils.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import homework.dto.UserInfo;
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

    public void register(UserInfo userInfo) {
        type(emailInput, userInfo.getEmail());
        type(passwordInput, userInfo.getPassword());
        click(registrationButton);
    }

    public void register() {
        type(emailInput, RandomUtils.randomEmail());
        type(passwordInput, RandomUtils.randomPassword());
        click(registrationButton);
    } public void registerWithLombok(UserInfoLombok user) {
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

    public By errorMessage() {
        return By.xpath("//div[text()='Registration failed with code 400']");
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
