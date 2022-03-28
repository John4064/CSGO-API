package tech.parkhurst.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepo extends JpaRepository<HltvMatch, Integer> {

    //List<HltvMatch> findByTeam(String name);
    //List<HltvMatch> getVP();
}