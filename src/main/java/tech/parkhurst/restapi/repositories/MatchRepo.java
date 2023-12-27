package tech.parkhurst.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.parkhurst.restapi.entities.HltvMatch;

import java.util.List;

public interface MatchRepo extends JpaRepository<HltvMatch, String> {

    List<HltvMatch> findByTypeofmatchIgnoreCase(String typeofmatch);

    List<HltvMatch> findByTeamAIgnoreCaseOrTeamBIgnoreCase(String teamA, String teamB);
    List<HltvMatch> findByCompetitionIsIgnoreCase(String competition);

    @Query(value = "SELECT * FROM hltv_match LIMIT :num", nativeQuery = true)
    List<HltvMatch> findAllTopN(@Param("num") int num);

    @Query(value="select match_id from hltv_match;",nativeQuery = true)
    List<String> findAllIds();

}