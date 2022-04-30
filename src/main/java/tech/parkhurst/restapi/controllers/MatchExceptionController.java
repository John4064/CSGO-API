package tech.parkhurst.restapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.parkhurst.restapi.exceptions.MatchNotfoundException;
import tech.parkhurst.restapi.exceptions.MatchIdFoundException;

@ControllerAdvice
public class MatchExceptionController {

    @ExceptionHandler(value = MatchNotfoundException.class)
    public ResponseEntity<Object> exception(MatchNotfoundException exception) {
        return ResponseEntity.ok().body("No match has been found!");
    }

    @ExceptionHandler(value = MatchIdFoundException.class)
    public ResponseEntity<Object> exception(MatchIdFoundException exception) {
        return ResponseEntity.ok().body("This Match already exists in the db!");
    }

}
