package tech.parkhurst.restapi.services;

import tech.parkhurst.restapi.entities.HltvMatch;

import java.util.ArrayList;
import java.util.List;

public interface MatchService {
    int getMatchCount();
    List<String> getIDList();
    List<HltvMatch> getUserList();
    List<HltvMatch> findTopNMatches(int num);
    HltvMatch getMatchById(String id);
    List<HltvMatch> getComp(String competition);
    List<HltvMatch> findTeam(String name);
    List<HltvMatch> gatherType(String typeofmatch);
    HltvMatch insertMatches(ArrayList<HltvMatch> match);
}
