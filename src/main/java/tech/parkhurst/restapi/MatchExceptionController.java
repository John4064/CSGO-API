package tech.parkhurst.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MatchExceptionController {

    @ExceptionHandler(value = MatchNotfoundException.class)
    public ResponseEntity<Object> exception(MatchNotfoundException exception) {
        return ResponseEntity.ok().body("No match has been found!");
    }

}
