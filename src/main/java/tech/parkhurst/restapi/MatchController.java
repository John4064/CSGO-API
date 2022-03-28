package tech.parkhurst.restapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

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
        HltvMatch specMatch = this.services.getUserById(id);
        if(specMatch != null){
            return ResponseEntity.ok().body(specMatch);
        }else{
            System.out.println("TEST123");
            throw new MatchNotfoundException();
        }
    }

    /*
    @ExceptionHandler(value = MatchNotfoundException.class)
    public ResponseEntity<Object> exception(MatchNotfoundException exception) {

    }
     */




    @GetMapping("/error")
    public ResponseEntity albino(){
        return ResponseEntity.ok().body("Error has Occured");
    }
}
