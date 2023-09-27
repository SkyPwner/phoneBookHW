package classwork.tests;

import classwork.dto.UserDTO;
import classwork.dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");
        app.userHelper().login(userDTO);
        Assert.assertTrue(app.userHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");
        app.userHelper().login(userDTOWith);
        Assert.assertTrue(app.userHelper().validatePopUpMessageSuccessAfterLogin());
    }
}
