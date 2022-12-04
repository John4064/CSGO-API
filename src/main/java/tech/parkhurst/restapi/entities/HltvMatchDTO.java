package tech.parkhurst.restapi.entities;


public class HltvMatchDTO {

    private String teamA;

    private String teamB;

    private String url;

    private String competition;

    private String typeofmatch;

    private String matchid;

    private String scoreA;

    private String scoreB;

    //Accessors
    public String getScoreA() {
        return scoreA;
    }

    public String getScoreB() {
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
}
