package tech.parkhurst.restapi;
import javax.persistence.*;


@Entity
@Table(name = "hltv_match", schema = "csgo_hltv")
public class HltvMatch {

    @Column(name="team_A")
    private String team_A;
    @Column(name="team_B")
    private String team_B;
    @Column(name="match_url")
    private String url;
    @Column(name="competition")
    private String competition;
    @Column(name="type_of_match")
    private String typeofmatch;
    @Id
    @Column(name="match_id")
    private int match_id;

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

    public int getMatch_id() {
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + match_id +
                ", Team A='" + team_A + '\'' +
                ", Team B='" + team_B + '\'' +
                ", url=" + url +
                '}';
    }
}
