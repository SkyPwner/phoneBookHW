package homework.pages;

import homework.dto.ContactInfo;
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

    public void addContact(ContactInfo contactInfo) {
        type(nameInput, contactInfo.getName());
        type(lastNameInput, contactInfo.getLastName());
        type(phoneInput, contactInfo.getPhone());
        type(emailInput, contactInfo.getEmail());
        type(addressInput, contactInfo.getAddress());
        type(descriptionInput, contactInfo.getDescription());
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
