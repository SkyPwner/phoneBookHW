package homework.dto;

public class UserInfoWith {

    String name;
    String lastName;
    String email;
    String password;

    public UserInfoWith(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserInfoWith() {
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

    public UserInfoWith withName(String name) {
        return new UserInfoWith(name, lastName, email, password);

    }

    public UserInfoWith withLastName(String lastName) {
        return new UserInfoWith(name, lastName, email, password);

    }

    public UserInfoWith withEmail(String email) {
        return new UserInfoWith(name, lastName, email, password);

    }

    public UserInfoWith withPassword(String password) {
        return new UserInfoWith(name, lastName, email, password);
    }
}
