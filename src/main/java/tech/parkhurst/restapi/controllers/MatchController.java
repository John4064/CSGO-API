package tech.parkhurst.restapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tech.parkhurst.restapi.exceptions.MatchNotfoundException;
import tech.parkhurst.restapi.services.impl.MatchServiceImpl;
import tech.parkhurst.restapi.entities.HltvMatch;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchServiceImpl services;

    @GetMapping("/findall")
    public ResponseEntity<List<HltvMatch>> findAll(){
        return ResponseEntity.ok(services.getUserList());
    }

    @GetMapping("/gatherids")
    public ResponseEntity<List<String>> getIds(){
        return ResponseEntity.ok(services.getIDList());
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<HltvMatch> getMatchById(@PathVariable String id) {
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
    public ResponseEntity<List<HltvMatch>> topNMatches(@PathVariable int num){
        List<HltvMatch> matches = services.findTopNMatches(num);
        return ResponseEntity.ok(matches);
    }



    @GetMapping("/error")
    public ResponseEntity<String> catchError(){
        return ResponseEntity.ok().body("Error has occurred");
    }


    @RequestMapping("*")
    public ResponseEntity<String> catchAll(){
        //Catch any unspecified endpoints
        return ResponseEntity.ok().body("This End Point does not Exist!");
    }

}
