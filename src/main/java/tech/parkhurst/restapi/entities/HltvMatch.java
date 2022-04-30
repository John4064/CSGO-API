package tech.parkhurst.restapi.entities;
import javax.persistence.*;


@Entity
@Table(name = "hltv_match", schema = "csgo_hltv")
public class HltvMatch {

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchid;
    //    @Column(name="team_B")
    //    private String teamB;
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

    public int getMatchid() {
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
}
