package tech.kddez.forumhub.infra.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestErrorMessage {

    private HttpStatus status;
    private String message;

    public RestErrorMessage(HttpStatus httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }
}
