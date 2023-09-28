package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

    By aboutText = By.xpath("//h1[contains(text(),'Contacts Web Application')]");
    By homeLink = By.xpath("//a[@href='/home']");
    By loginLink = By.xpath("//a[text()='LOGIN']");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeLink() {
        click(homeLink);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public String getAboutText() {
        return getText(aboutText);
    }
}
