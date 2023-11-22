package dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ContactInfo {
    String address;
    String description;
    String email;
    String id;
    String lastName;
    String name;
    String phone;

    public ContactInfo() {

    }
}
