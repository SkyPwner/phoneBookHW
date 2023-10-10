package homework.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class UserInfoLombok {
    String name;
    String lastName;
    String email;
    String password;
}

