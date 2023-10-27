package tests;

import dto.ContactInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class AddContactTests extends BaseTest {
    @BeforeMethod
    public void preconditionsLogin() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
        app.loginPage().loginUserInfoLombok(user);
    }

    @Test
    public void addContactPositiveTest() {
        String phone = RandomUtils.generateStringDigits(12);
        ContactInfo contact = ContactInfo.builder()
                .name("Test Name")
                .lastName("Test Last Name")
                .phone(phone)
                .email("test@example.com")
                .address("Haifa")
                .description("Test description")
                .build();
        app.addContactPage().addContact(contact);
        Assert.assertTrue(app.addContactPage().isContactDisplayed(phone));
    }
}