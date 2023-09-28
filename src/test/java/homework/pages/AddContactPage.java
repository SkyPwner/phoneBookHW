package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage extends BasePage {

    By homeLink = By.xpath("//a[@href='/home']");
    By aboutLink = By.xpath("//a[@href='/about']");
    By contactsLink = By.xpath("//a[@href='/contacts']");
    By signOutButton = By.xpath("//button[text()='Sign Out']");
    By nameInput = By.xpath("//input[@placeholder='Name']");
    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By phoneInput = By.xpath("//input[@placeholder='Phone']");
    By emailInput = By.xpath("//input[@placeholder='email']");
    By addressInput = By.xpath("//input[@placeholder='Address']");
    By descriptionInput = By.xpath("//input[@placeholder='description']");
    By saveButton = By.xpath("//button[b[text()='Save']]");

    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        type(nameInput, name);
    }

    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void enterPhone(String phone) {
        type(phoneInput, phone);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterAddress(String address) {
        type(addressInput, address);
    }

    public void enterDescription(String description) {
        type(descriptionInput, description);
    }

    public void clickSaveButton() {
        click(saveButton);
    }

    public boolean isContactDisplayed(String contactName) {
        By contactLocator = By.xpath("//h2[text()='" + contactName + "']");
        try {
            return driver.findElement(contactLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
