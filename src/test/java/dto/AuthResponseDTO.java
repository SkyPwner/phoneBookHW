package dto;

import lombok.Getter;

@Getter
public class AuthResponseDTO {
    String token;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}