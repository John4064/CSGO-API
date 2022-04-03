package tech.parkhurst.restapi.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.parkhurst.restapi.entities.HltvMatch;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/addmatch/")

    public HltvMatch addMatch(){
        HltvMatch test = new HltvMatch();
         return test;
    }
}
