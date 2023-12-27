package tech.parkhurst.restapi.entities;


import java.util.List;
import org.springframework.data.annotation.Id;

//CONVERTING THIS TO MONGO

public class HltvPlayer {
    @Id
    private String playerName;


    private List<String> teamName;

    private int mapCount;

    private int roundCount;

    private int kdDiff;

    private float playerKD;

    private float playerRating;

    public HltvPlayer(String playerName, List<String> teamName, int mapCount, int roundCount, int kdDiff, float playerKD, float playerRating) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.mapCount = mapCount;
        this.roundCount = roundCount;
        this.kdDiff = kdDiff;
        this.playerKD = playerKD;
        this.playerRating = playerRating;
    }

    public HltvPlayer() {
    }

    @Override
    public String toString() {
        return "HltvPlayer{" +
                "playerName='" + playerName + '\'' +
                ", teamName=" + teamName +
                ", mapCount=" + mapCount +
                ", roundCount=" + roundCount +
                ", kdDiff=" + kdDiff +
                ", playerKD=" + playerKD +
                ", playerRating=" + playerRating +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<String> getTeamName() {
        return teamName;
    }

    public void setTeamName(List<String> teamName) {
        this.teamName = teamName;
    }

    public int getMapCount() {
        return mapCount;
    }

    public void setMapCount(int mapCount) {
        this.mapCount = mapCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getKdDiff() {
        return kdDiff;
    }

    public void setKdDiff(int kdDiff) {
        this.kdDiff = kdDiff;
    }

    public float getPlayerKD() {
        return playerKD;
    }

    public void setPlayerKD(float playerKD) {
        this.playerKD = playerKD;
    }

    public float getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(float playerRating) {
        this.playerRating = playerRating;
    }
}
