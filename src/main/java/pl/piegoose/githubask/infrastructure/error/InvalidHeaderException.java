package pl.piegoose.githubask.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidHeaderException extends RuntimeException {
    public InvalidHeaderException(String message){
        super(message);
    }
}
