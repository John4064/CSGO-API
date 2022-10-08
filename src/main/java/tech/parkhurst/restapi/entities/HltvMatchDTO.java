package tech.parkhurst.restapi.entities;


public class HltvMatchDTO {

    private String teamA;

    private String teamB;

    private String url;

    private String competition;

    private String typeofmatch;

    private int matchid;

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
