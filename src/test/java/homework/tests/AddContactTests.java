package homework.tests;

import homework.dto.UserInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTest {

    @Test
    public void addContactPositiveTest() {
        app.homePage().clickLoginLink();
        UserInfo userInfo = new UserInfo("testqa20@gmail.com", "123456Aa$");
        app.loginPage().login(userInfo);
        app.userProfilePage().clickAddLink();

        String name = "Test Name";
        String lastName = "Test Last Name";
        String phone = "1234567890";
        String email = "test@example.com";
        String address = "Haifa";
        String description = "Test description";

        app.addContactPage().enterName(name);
        app.addContactPage().enterLastName(lastName);
        app.addContactPage().enterPhone(phone);
        app.addContactPage().enterEmail(email);
        app.addContactPage().enterAddress(address);
        app.addContactPage().enterDescription(description);

        app.addContactPage().clickSaveButton();

        By ContactLocator = By.xpath("//h2[text()='Test Name']");
        app.addContactPage().isContactDisplayed("Test Name");
    }
}