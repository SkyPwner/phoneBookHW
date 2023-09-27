package homework.pages;

import homework.dto.UserInfoWith;
import homework.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import homework.dto.UserInfo;

public class LoginPage extends BasePage {

    By emailInput = By.xpath("//input[@name='email']");
    By passwordInput = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@name='login']");
    By registrationButton = By.xpath("//button[@name='registration']");
    By homeLink = By.xpath("//a[text()='HOME']");
    By aboutLink = By.xpath("//a[text()='ABOUT']");

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

    public void clickRegistrationButton() {
        click(registrationButton);
    }

    public void clickHomeLink() {
        click(homeLink);
    }

    public void clickAboutLink() {
        click(aboutLink);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
