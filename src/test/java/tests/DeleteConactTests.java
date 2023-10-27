package tests;

import dto.ContactInfo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class DeleteConactTests extends BaseTest{

    @BeforeMethod
    public void preconditionsLogin() {
        logoutIfLogin();
        app.homePage().clickLoginLink();
        app.loginPage().loginUserInfoLombok(user);
    }

    @AfterClass(alwaysRun = true)
    public void postConditions() {
        logoutIfLogin();
    }

    @Test
    public void deleteCreatedContactPositive() {
        String phone = RandomUtils.generateStringDigits(12);
        ContactInfo contactInfo = ContactInfo.builder()
                .address("Haifa")
                .description("test")
                .email("test1@mail.ru")
                .lastName("Tetris")
                .name("Hello")
                .phone(phone)
                .build();
        app.addContactPage().addContact(contactInfo);
        app.getAddContactPage().openContactInfoByPhone(phone);
        app.getAddContactPage().removeActiveContact();
        Assert.assertFalse(app.getAddContactPage().isContactDisplayed(phone));
    }
}
