package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.AuthResponseDTO;
import dto.UserInfoLombok;

import static com.jayway.restassured.RestAssured.given;

public class UserApi extends BaseApi {

    Response responseLogin = null;

    private Response loginRequest(UserInfoLombok user) {
        System.out.println("----------------------- loginRequest method run");
        responseLogin = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUrl + "/v1/user/login/usernamepassword")
                .thenReturn();
        return responseLogin;
    }

    public void setResponseLoginNull() {
        responseLogin = null;
    }

    public int getStatusCodeResponseLogin(UserInfoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        return responseLogin.getStatusCode();
    }

    public String getTokenFromLoginResponse(UserInfoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        return responseLogin.getBody().as(AuthResponseDTO.class).getToken();
    }
    private Response registrationRequest(UserInfoLombok user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUrl + "/v1/user/registration/usernamepassword")
                .thenReturn();
    }

    public int getStatusCodeResponseRegistration(UserInfoLombok user) {
        Response response = registrationRequest(user);
        return response.getStatusCode();
    }

    public String getTokenFromRegistrationResponse(UserInfoLombok user) {
        Response response = registrationRequest(user);
        return response.getStatusCode() == 200 ? response.getBody().as(AuthResponseDTO.class).getToken() : null;
    }
}