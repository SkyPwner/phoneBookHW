package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.ContactInfo;
import dto.MessageResponseDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ContactsService extends BaseApi {
    Response responseAddNewContact = null;
    Response responseUpdateContact = null;
    Response responseGetContact = null;
    Response responseDeleteContact = null;

    // ---------------------- Add New Contact ----------------------

    public Response getResponseAddNewContact(ContactInfo contactInfo, String token) {
        responseAddNewContact = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(contactInfo)
                .when()
                .post(baseUrl + "/v1/contacts");
        return responseAddNewContact;
    }

    public int getStatusCodeResponseAddNewContact(ContactInfo contactInfo, String token) {
        if (responseAddNewContact == null) {
            responseAddNewContact = getResponseAddNewContact(contactInfo, token);
        }
        return responseAddNewContact.getStatusCode();
    }

    public String getMessagePositiveResponseAddNewContact(ContactInfo contactInfo, String token) {
        if (responseAddNewContact == null) {
            responseAddNewContact = getResponseAddNewContact(contactInfo, token);
        }
        return responseAddNewContact.getBody().as(MessageResponseDTO.class).getMessage();
    }


    // ---------------------- Update Contact ----------------------

    private Response getResponseUpdateContact(ContactInfo contactInfo, String token) {
        responseUpdateContact = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(contactInfo)
                .when()
                .put(baseUrl + "/v1/contacts/");
        return responseUpdateContact;
    }

    public int getStatusCodeResponseUpdateContact(ContactInfo contactInfo, String token) {
        if (responseUpdateContact == null) {
            responseUpdateContact = getResponseUpdateContact(contactInfo, token);
        }
        return responseUpdateContact.getStatusCode();
    }

    // ---------------------- Delete Contact ----------------------

    public int deleteContact(String contactId, String token) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .pathParam("id", contactId)
                .log().all()
                .when()
                .delete(baseUrl + "/v1/contacts/{id}")
                .then()
                .log().all()
                .extract()
                .response();
        return response.getStatusCode();
    }


    public MessageResponseDTO deleteAllContacts(String token) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete(baseUrl + "/v1/contacts/clear")
                .thenReturn();

        return response.getStatusCode() == 200 ? response.getBody().as(MessageResponseDTO.class) : null;
    }

    // ---------------------- Get Contact ----------------------

    public List<ContactInfo> getAllContacts(String token) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get(baseUrl + "/v1/contacts")
                .then()
                .log().all()
                .extract().response();

        if (response.getStatusCode() == 200) {
            List<Map<String, Object>> contactMaps = response.getBody().jsonPath().getList("contacts");

            List<ContactInfo> contacts = new ArrayList<>();
            for (Map<String, Object> contactMap : contactMaps) {
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setId((String) contactMap.get("id"));
                contactInfo.setName((String) contactMap.get("name"));
                contactInfo.setLastName((String) contactMap.get("lastName"));
                contactInfo.setEmail((String) contactMap.get("email"));
                contactInfo.setPhone((String) contactMap.get("phone"));
                contactInfo.setAddress((String) contactMap.get("address"));
                contactInfo.setDescription((String) contactMap.get("description"));

                contacts.add(contactInfo);
            }

            return contacts;
        } else {
            System.out.println("Error retrieving contacts: " + response.getStatusCode());
            System.out.println("Response body: " + response.getBody().asString());
            return Collections.emptyList();
        }
    }


    public ContactInfo findContactById(String contactId, String token) {
        List<ContactInfo> allContacts = getAllContacts(token);

        for (ContactInfo contact : allContacts) {
            if (contact.getId().equals(contactId)) {
                return contact;
            }
        }

        System.out.println("Contact with id '" + contactId + "' not found.");
        return null;
    }
}