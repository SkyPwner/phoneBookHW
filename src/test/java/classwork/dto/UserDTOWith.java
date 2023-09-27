package classwork.dto;

import java.util.List;

public class UserDTOWith {

    String name;
    String lastName;
    String email;
    String password;

    public UserDTOWith(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTOWith() {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserDTOWith withName(String name) {
        return new UserDTOWith(name, lastName, email, password);

    }

    public UserDTOWith withLastName(String lastName) {
        return new UserDTOWith(name, lastName, email, password);

    }

    public UserDTOWith withEmail(String email) {
        return new UserDTOWith(name, lastName, email, password);

    }

    public UserDTOWith withPassword(String password) {
        return new UserDTOWith(name, lastName, email, password);
    }
}
