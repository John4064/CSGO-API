package tech.parkhurst.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.parkhurst.restapi.entities.HltvMatch;

public interface MatchRepo extends JpaRepository<HltvMatch, Integer> {

    //List<HltvMatch> findByTeam(String name);
    //List<HltvMatch> getVP();
}