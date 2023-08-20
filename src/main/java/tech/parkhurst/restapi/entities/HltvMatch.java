package tech.parkhurst.restapi.entities;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "hltv_match", schema = "testdb")
public class HltvMatch {

    public HltvMatch(){
    }
    @JsonCreator
    public HltvMatch(@JsonProperty("matchid") String matchid, @JsonProperty("teamA") String teamA, @JsonProperty("teamB") String teamB, @JsonProperty("url") String url, @JsonProperty("scoreA") int scoreA, @JsonProperty("scoreB") int scoreB, @JsonProperty("competition") String competition, @JsonProperty("typeofmatch") String typeofmatch) {
        this.matchid=matchid;
        this.teamA=teamA;
        this.teamB=teamB;
        this.url=url;
        this.competition=competition;
        this.typeofmatch=typeofmatch;
        this.scoreA=scoreA;
        this.scoreB=scoreB;
    }

    @Column(name="team_A")
    private String teamA;

    @Column(name="team_B")
    private String teamB;

    @Column(name="match_url")
    private String url;

    @Column(name="competition")
    private String competition;

    @Column(name="type_of_match")
    private String typeofmatch;

    @Id
    @Column(name="match_id")
    private String matchid;

    @Column(name="score_tA")
    private int scoreA;

    @Column(name="score_tB")
    private int scoreB;

    //Accessors
    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public String getCompetition() {
        return competition;
    }

    public String getMatchid() {
        return matchid;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getTypeofmatch() {
        return typeofmatch;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + matchid +
                ", Team A='" + teamA + '\'' +
                ", Team B='" + teamB + '\'' +
                ", url=" + url +
                '}';
    }

    public void printData(){
//        System.out.println("Team A: " + teamA);
//        System.out.println("Team B: " + teamB);
//        System.out.println("Score for teamA and teamB: "+scoreTA+" "+scoreTB);
//        System.out.println("Event Name: " + eventName);
//        System.out.println("Map: " + map);
//        System.out.println("URL: "+baseUrl+href);
//        System.out.println("COUNT: "+a);
//        System.out.println("====================");
        return;
    }
}
