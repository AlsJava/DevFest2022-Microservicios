package edu.alsjava.deffest.util;

import edu.alsjava.deffest.model.exception.ErrorSavingUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvisorHandler {

    @ExceptionHandler(ErrorSavingUserException.class)
    public ResponseEntity<APIError> handle(ErrorSavingUserException ex) {
        return createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<APIError> createResponse(String message, HttpStatus httpStatus) {
        log.info("Generating Error {}  and message {}", httpStatus, message);
        APIError apiError = APIError.builder().message(message).status(httpStatus.value()).build();
        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
