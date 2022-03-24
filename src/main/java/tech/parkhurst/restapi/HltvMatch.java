package tech.parkhurst.restapi;
import javax.persistence.*;


@Entity
@Table(name = "hltv_match", schema = "csgo_hltv")
public class HltvMatch {

    private String team_A;
    private String team_B;
    private String url;
    private String competition;
    private String typeofmatch;
    @Id
    private String match_id;

    private int scoreA;
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

    public String getMatch_id() {
        return match_id;
    }

    public String getTeam_A() {
        return team_A;
    }

    public String getTeam_B() {
        return team_B;
    }

    public String getTypeofmatch() {
        return typeofmatch;
    }

    public String getUrl() {
        return url;
    }
}
