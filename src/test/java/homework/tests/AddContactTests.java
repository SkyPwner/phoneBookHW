package homework.tests;

import homework.dto.ContactInfo;
import homework.dto.UserInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTest {

    @Test
    public void addContactPositiveTest() {
        app.homePage().clickLoginLink();
        UserInfo userInfo = new UserInfo("mytest@mail.ru", "12345678Aa$");
        app.loginPage().login(userInfo);
        app.userProfilePage().clickAddLink();

        ContactInfo contact = new ContactInfo();
        contact.setName("Test Name");
        contact.setLastName("Test Last Name");
        contact.setPhone("1234567890");
        contact.setEmail("test@example.com");
        contact.setAddress("Haifa");
        contact.setDescription("Test description");

        app.addContactPage().addContact(contact);
        Assert.assertTrue(app.addContactPage().isContactDisplayed(contact.getName()));
    }
}