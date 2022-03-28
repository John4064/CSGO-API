package tech.parkhurst.restapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping("/*")
    public ResponseEntity catchAll(){
        //Catch any unspecified endpoints
        return ResponseEntity.ok().body("This End Point does not Exist!");
    }
}
