package tests.restassured;

import api.UserApi;
import dto.UserInfoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestsRA extends BaseRA{
    @Test
    public void registrationStatusCodeTest() {
        UserInfoLombok newUser = UserInfoLombok.builder()
                .username("newuser1245@example.com")
                .password("Password123!")
                .build();
        Assert.assertEquals(userApi.getStatusCodeResponseRegistration(newUser), 200,
                "Status code not 200 for registration test with correct data");
    }

    @Test
    public void registrationTokenTest() {
        UserInfoLombok newUser = UserInfoLombok.builder()
                .username("newuser1235@example.com")
                .password("Password123!")
                .build();
        Assert.assertNotNull(userApi.getTokenFromRegistrationResponse(newUser),
                "Token is null for registration test with correct data");
    }

    @Test
    public void negativeRegistrationTest() {
        UserInfoLombok invalidUser = UserInfoLombok.builder()
                .username("invalidemail")
                .password("pass")
                .build();
        Assert.assertNotEquals(userApi.getStatusCodeResponseRegistration(invalidUser), 200,
                "Status code is 200 for registration test with incorrect data");
    }
}
