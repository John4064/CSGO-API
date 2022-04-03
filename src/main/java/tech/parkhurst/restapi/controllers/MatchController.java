package tech.parkhurst.restapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tech.parkhurst.restapi.exceptions.MatchNotfoundException;
import tech.parkhurst.restapi.services.MatchServices;
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

    @GetMapping("/match/{id}")
    public ResponseEntity<HltvMatch> getMatchById(@PathVariable int id) {
        HltvMatch specMatch = this.services.getMatchById(id);
        if(specMatch != null){
            return ResponseEntity.ok().body(specMatch);
        }else{
            throw new MatchNotfoundException();
        }
    }


    @GetMapping("/comp/{name}")
    public ResponseEntity<List<HltvMatch>> getComp(@PathVariable String name){
        return ResponseEntity.ok().body(this.services.getComp(name));
    }


    @GetMapping("/team/{name}")
    public ResponseEntity<List<HltvMatch>> findTeamMatches(@PathVariable String name){
        return ResponseEntity.ok(this.services.findTeam(name));
    }


    @GetMapping("/type/{typematch}")
    public ResponseEntity<List<HltvMatch>> gatherTypes(@PathVariable String typematch){
        return ResponseEntity.ok(this.services.gatherType(typematch));
    }


    @GetMapping("/top/{num}")
    public ResponseEntity<String> topNum(@PathVariable int num){
        List<HltvMatch> topCollection = services.getUserList();
        for(int i = 0; i < num;i++){
            System.out.println(topCollection.get(i));
        }
        return ResponseEntity.ok("a");
    }



    @GetMapping("/error")
    public ResponseEntity catchError(){
        return ResponseEntity.ok().body("Error has Occured");
    }


    @RequestMapping("*")
    public ResponseEntity catchAll(){
        //Catch any unspecified endpoints
        return ResponseEntity.ok().body("This End Point does not Exist!");
    }

}
