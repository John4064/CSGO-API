package tech.parkhurst.restapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<HltvMatch>> test(){
        return ResponseEntity.ok(services.getUserList());
    }
    @GetMapping("/error")
    public String albino(){
        return "Error";
    }
}
