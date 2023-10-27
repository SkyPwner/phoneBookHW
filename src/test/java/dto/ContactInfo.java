package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ContactInfo {
    String address;
    String description;
    String email;
    String id;
    String lastName;
    String name;
    String phone;
}
