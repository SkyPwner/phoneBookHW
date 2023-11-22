package tests.restassured;

import api.ContactsService;
import api.UserApi;
import dto.ContactInfo;
import dto.UserInfoLombok;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

public class BaseRA {
    UserApi userApi = new UserApi();
    ContactsService contactsService = new ContactsService();
    String token = "";
    RandomUtils randomUtils = new RandomUtils();

    UserInfoLombok user = UserInfoLombok.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeSuite
    public void preCondApiRA() {
        token = userApi.getTokenFromLoginResponse(user);
    }

    public ContactInfo createNewContact() {
        String phoneNumber = RandomUtils.generateStringDigits(12);
        return ContactInfo.builder()
                .address("Haifa")
                .description("TestForUpdateContact")
                .email("testForUpdateContact@mail.com")
                .id("0")
                .lastName("Aa")
                .name("Bb")
                .phone(phoneNumber)
                .build();
    }
}