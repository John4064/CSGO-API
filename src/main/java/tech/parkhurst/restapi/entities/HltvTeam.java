package tech.parkhurst.restapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hltv_team")
public class HltvTeam {

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "year")
    private int year;

    @Column(name = "map_count")
    private int mapCount;

    @Column(name = "kd_diff")
    private int kdDiff;

    @Column(name = "team_kd")
    private float teamKD;

    @Column(name = "average_rating")
    private float averageRating;

    @Id
    @Column(name = "team_id")
    private int teamID;

    public HltvTeam(String teamName, int year, int mapCount, int kdDiff, float teamKD, float averageRating, int teamID) {
        this.teamName = teamName;
        this.year = year;
        this.mapCount = mapCount;
        this.kdDiff = kdDiff;
        this.teamKD = teamKD;
        this.averageRating = averageRating;
        this.teamID = teamID;
    }

    public HltvTeam() {
    }

    @Override
    public String toString() {
        return "HltvTeam{" +
                "teamName='" + teamName + '\'' +
                ", year=" + year +
                ", mapCount=" + mapCount +
                ", kdDiff=" + kdDiff +
                ", teamKD=" + teamKD +
                ", teamID=" + teamID +
                ", averageRating=" + averageRating +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMapCount() {
        return mapCount;
    }

    public void setMapCount(int mapCount) {
        this.mapCount = mapCount;
    }

    public int getKdDiff() {
        return kdDiff;
    }

    public void setKdDiff(int kdDiff) {
        this.kdDiff = kdDiff;
    }

    public float getTeamKD() {
        return teamKD;
    }

    public void setTeamKD(float teamKD) {
        this.teamKD = teamKD;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }
}
