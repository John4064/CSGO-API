package tech.parkhurst.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import tech.parkhurst.restapi.entities.HltvMatch;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.repositories.MatchRepo;

import java.util.List;

@Service
public class MatchServices {

    @Autowired
    private MatchRepo MatchRepository;


    public List<HltvMatch> getUserList() {
        return MatchRepository.findAll();
    }

    public HltvMatch getMatchById(int id) {
        return MatchRepository.findById(id).orElse(null);
    }


    /*
    public List<HltvMatch> findTeam(String name){
        return MatchRepository.findByTeam(name);
    }

     */
}
