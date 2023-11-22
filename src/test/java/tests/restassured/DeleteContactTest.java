package tests.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import dto.MessageResponseDTO;

public class DeleteContactTest extends BaseRA {

    @Test
    public void deleteAllContactsWhenExist() {
        contactsService.getStatusCodeResponseAddNewContact(createNewContact(), token);

        MessageResponseDTO response = contactsService.deleteAllContacts(token);
        Assert.assertNotNull(response, "Response should not be null");
        Assert.assertEquals(response.getMessage(), "All contacts was deleted!", "Unexpected response message");
    }

    @Test
    public void deleteAllContactsWhenNotExist() {
        contactsService.deleteAllContacts(token);

        MessageResponseDTO response = contactsService.deleteAllContacts(token);
        Assert.assertNotNull(response, "Response should not be null even when no contacts exist");
        Assert.assertEquals(response.getMessage(), "All contacts was deleted!", "Unexpected response message");
    }

    @Test
    public void deleteNonExistentContactById() {
        int statusCode = contactsService.deleteContact("nonExistentContactId", token);
        Assert.assertEquals(statusCode, 400, "Expected 404 status code for non-existent contact");
    }
}
