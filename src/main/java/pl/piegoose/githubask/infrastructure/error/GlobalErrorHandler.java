package pl.piegoose.githubask.infrastructure.error;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
@Log4j2
public class UserErrorHandler {


    private final View error;

    public UserErrorHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleException(FeignException.FeignClientException exception) {
        return ResponseEntity
                .status(exception.status())
                .body(Map.of(
                        "status", exception.status(),
                        "error", "User does not exist"
                ));
    }


}
