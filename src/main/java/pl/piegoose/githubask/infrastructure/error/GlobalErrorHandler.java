package pl.piegoose.githubask.infrastructure.error;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Log4j2
public class GlobalErrorHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleException(FeignException.FeignClientException exception) {
        return ResponseEntity
                .status(exception.status())
                .body(Map.of(
                        "status", exception.status(),
                        "error", "User does not exist"
                ));
    }

    @ExceptionHandler(InvalidHeaderException.class)
    @ResponseBody
    public ResponseEntity<ApiErrorResponse> headerInvalidError(InvalidHeaderException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(
                        new ApiErrorResponse(406, e.getMessage()));
    }


}
