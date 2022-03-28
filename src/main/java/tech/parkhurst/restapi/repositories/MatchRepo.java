package tech.parkhurst.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.parkhurst.restapi.entities.HltvMatch;

import java.util.List;

public interface MatchRepo extends JpaRepository<HltvMatch, Integer> {

    List<HltvMatch> findByTeamA(String teamA);
    List<HltvMatch> findByCompetitionIsIgnoreCase(String competition);

    //List<HltvMatch> findHltvMatchesByTeam_A(String team_A);
}