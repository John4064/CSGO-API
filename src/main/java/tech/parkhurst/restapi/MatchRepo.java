package tech.parkhurst.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<HltvMatch, Integer> {


}