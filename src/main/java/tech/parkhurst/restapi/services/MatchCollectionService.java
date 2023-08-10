package tech.parkhurst.restapi.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class MatchCollectionService {
    @PostConstruct
    public void init(){
        System.out.println("GATHER STATISTICS");
    }



}
