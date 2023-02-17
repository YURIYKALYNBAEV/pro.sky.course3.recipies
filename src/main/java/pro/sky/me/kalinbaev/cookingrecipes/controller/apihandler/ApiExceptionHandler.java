package pro.sky.me.kalinbaev.cookingrecipes.controller.apihandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;

@RestControllerAdvice
public class ApiExceptionHandler {
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
