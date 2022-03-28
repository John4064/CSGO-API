package tech.parkhurst.restapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tech.parkhurst.restapi.MatchNotfoundException;
import tech.parkhurst.restapi.MatchServices;
import tech.parkhurst.restapi.entities.HltvMatch;

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

    @GetMapping("/match/{id}")
    public ResponseEntity<HltvMatch> getMatchById(@PathVariable int id) {
        HltvMatch specMatch = this.services.getMatchById(id);
        if(specMatch != null){
            return ResponseEntity.ok().body(specMatch);
        }else{
            throw new MatchNotfoundException();
        }
    }

    @GetMapping("/error")
    public ResponseEntity catchError(){
        return ResponseEntity.ok().body("Error has Occured");
    }

    @GetMapping("/*")
    public ResponseEntity catchAll(){
        return ResponseEntity.ok().body("This End Point does not Exist!");
    }

}
