package pages;

import dto.ContactInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddContactPage extends BasePage {

    By homeLink = By.xpath("//a[@href='/home']");
    By aboutLink = By.xpath("//a[@href='/about']");
    By contactsLink = By.xpath("//a[@href='/contacts']");
    By signOutButton = By.xpath("//button[text()='Sign Out']");
    By addButton = By.xpath("//a[@href='/add']");
    By nameInput = By.xpath("//input[@placeholder='Name']");
    By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    By phoneInput = By.xpath("//input[@placeholder='Phone']");
    By emailInput = By.xpath("//input[@placeholder='email']");
    By addressInput = By.xpath("//input[@placeholder='Address']");
    By descriptionInput = By.xpath("//input[@placeholder='description']");
    By saveButton = By.xpath("//button[b[text()='Save']]");
    By removeContactButton = By.xpath("//button[text()='Remove']");
    By textH3ContactList = By.xpath("//h3");


    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    public void addContact(ContactInfo contactInfo) {
        click(addButton);
        type(nameInput, contactInfo.getName());
        type(lastNameInput, contactInfo.getLastName());
        type(phoneInput, contactInfo.getPhone());
        type(emailInput, contactInfo.getEmail());
        type(addressInput, contactInfo.getAddress());
        type(descriptionInput, contactInfo.getDescription());
        click(saveButton);
    }

    public boolean isContactDisplayed(String phone) {
        return isContactDisplayed(textH3ContactList, phone);
    }

    public boolean isContactDisplayed(By locator, String text) {
        return findElements(locator).stream()
                .anyMatch(element -> element.getText().equals(text));
    }

    public void openContactInfoByPhone(String phone)  {
        By phoneNumberInContacts = By.xpath("//h3[contains(text(),'" + phone + "')]");
        click(phoneNumberInContacts);
    }

    public void removeActiveContact(){
        click(removeContactButton);
        waitForElementToDisappear(removeContactButton);
    }
}
