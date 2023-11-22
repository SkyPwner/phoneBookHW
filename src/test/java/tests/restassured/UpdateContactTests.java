package tests.restassured;

import com.jayway.restassured.response.Response;
import dto.ContactInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UpdateContactTests extends BaseRA {

    @Test
    public void updateContactTest() {
        ContactInfo originalContact = createNewContact();
        Response response = contactsService.getResponseAddNewContact(originalContact, token);

        System.out.println(response.body().asString());
        ContactInfo foundContact = findContactByNameAndLastName(originalContact.getName(), originalContact.getLastName(), token);
        Assert.assertNotNull(foundContact, "Contact not found by criteria");

        ContactInfo updatedContact = ContactInfo.builder()
                .id(foundContact.getId())
                .name("Updated Name")
                .lastName(foundContact.getLastName())
                .email("updatedemail@example.com")
                .phone(foundContact.getPhone())
                .address(foundContact.getAddress())
                .description(foundContact.getDescription())
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
    private ContactInfo findContactByNameAndLastName(String name, String lastName, String token) {
        List<ContactInfo> allContacts = contactsService.getAllContacts(token);

        for (ContactInfo contact : allContacts) {
            if (contact.getName().equals(name) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }

        return null;
    }
}
