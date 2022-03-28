package tech.parkhurst.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.parkhurst.restapi.entities.HltvMatch;

import java.util.List;

public interface MatchRepo extends JpaRepository<HltvMatch, Integer> {

    List<HltvMatch> findByTeamAIgnoreCaseOrTeamBIgnoreCase(String teamA, String teamB);
    List<HltvMatch> findByCompetitionIsIgnoreCase(String competition);
}