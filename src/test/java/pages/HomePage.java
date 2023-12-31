package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By homeText = By.xpath("//h1[contains(text(),'Home Component')]");

    By homeLink = By.xpath("//a[@href='/home']");

    By aboutLink = By.xpath("//a[@href='/about']");
    By loginLink = By.xpath("//a[text()='LOGIN']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAboutLink() {
        click(aboutLink);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void clickHomeLink() {
        click(homeLink);
    }

    public String getHomeText() {
        return getText(homeText);
    }
}
