package pro.sky.me.kalinbaev.cookingrecipes.controller.apihandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;

@ControllerAdvice
public class ApiExceptionHandler {
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
