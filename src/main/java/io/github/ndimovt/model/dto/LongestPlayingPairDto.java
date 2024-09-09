package io.github.ndimovt.model.dto;

public class LongestPlayingPairDto implements Comparable<LongestPlayingPairDto>{
    private String name;
    private int totalPlayTime;
    private String teamName;

    public LongestPlayingPairDto() {
    }

    public LongestPlayingPairDto(String name, int totalPlayTime, String teamName) {
        this.name = name;
        this.totalPlayTime = totalPlayTime;
        this.teamName = teamName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(int totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return name + " / " + totalPlayTime +" / " + teamName ;
    }

    @Override
    public int compareTo(LongestPlayingPairDto o) {
        return Integer.compare(o.getTotalPlayTime(), this.totalPlayTime);
    }
}
