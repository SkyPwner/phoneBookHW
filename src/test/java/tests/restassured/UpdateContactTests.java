package tests.restassured;

import com.jayway.restassured.response.Response;
import dto.ContactInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateContactTests extends BaseRA {

    @Test
    public void updateContactTest() {
        ContactInfo originalContact = createNewContact();
        Response response = contactsService.getResponseAddNewContact(originalContact, token);

        System.out.println(response.body().asString());

        ContactInfo updatedContact = ContactInfo.builder()
                .id(response.body().jsonPath().getString("id"))
                .name("Updated Name")
                .lastName(originalContact.getLastName())
                .email("updatedemail@example.com")
                .phone(originalContact.getPhone())
                .address(originalContact.getAddress())
                .description(originalContact.getDescription())
                .build();

        contactsService.getStatusCodeResponseUpdateContact(updatedContact, token);

        ContactInfo retrievedContact = contactsService.findContactById(updatedContact.getId(), token);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(retrievedContact.getName(), "Updated Name",
                "Name not updated correctly");
        softAssert.assertEquals(retrievedContact.getEmail(), "updatedemail@example.com",
                "Email not updated correctly");

        softAssert.assertAll();
    }
}
