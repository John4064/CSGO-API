package tech.parkhurst.restapi.controllers;


import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.parkhurst.restapi.entities.HltvMatch;
import tech.parkhurst.restapi.services.MatchServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MatchServices services;

    //DOESNT save our json data
    @PostMapping("/add/")
    public ResponseEntity<HltvMatch> addUser(@RequestBody HltvMatch match) {
        return ResponseEntity.ok(this.services.createMatch(match));
    }
}
