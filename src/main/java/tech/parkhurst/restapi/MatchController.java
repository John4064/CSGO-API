package tech.parkhurst.restapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchServices services;

    @GetMapping("/findall")
    public ResponseEntity<List<HltvMatch>> findAll(){
        return ResponseEntity.ok(services.getUserList());
    }
    /*
    @GetMapping("/test123")
    public ResponseEntity<List<HltvMatch>> test123(){
        return ResponseEntity.ok(services.findTeam("fnatic"));
    }
*/


    @GetMapping("/user/{id}")
    public ResponseEntity<HltvMatch> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getUserById(id));
    }

    @GetMapping("/error")
    public ResponseEntity albino(){
        return ResponseEntity.ok().body("Error has Occured");
    }
}
