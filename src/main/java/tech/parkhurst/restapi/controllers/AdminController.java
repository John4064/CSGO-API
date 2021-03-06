package tech.parkhurst.restapi.controllers;


import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.parkhurst.restapi.entities.HltvMatch;
import tech.parkhurst.restapi.exceptions.MatchIdFoundException;
import tech.parkhurst.restapi.exceptions.MatchNotfoundException;
import tech.parkhurst.restapi.services.MatchServices;
import tech.parkhurst.restapi.exceptions.MatchIdFoundException;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MatchServices services;


    @PostMapping(value = "/add/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HltvMatch> addUser(@RequestBody HltvMatch match) {
        //Check if match id exists if it does throw
        try{
            HltvMatch checkM = this.services.getMatchById(match.getMatchid());
            if(checkM==null){
                //New match we must insert
                throw new MatchNotfoundException();
            }else{
                //Already Exists
                throw new MatchIdFoundException();
            }
        }catch(MatchNotfoundException excep){
            System.out.println("ADD NEW MATCH");
            return ResponseEntity.ok(this.services.createMatch(match));
        }

    }
}
