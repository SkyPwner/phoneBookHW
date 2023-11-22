package dto;

import lombok.Getter;

@Getter
public class MessageResponseDTO {
    String message;

    public MessageResponseDTO() {
    }

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}