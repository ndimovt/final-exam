package io.github.ndimovt.model.dto;

/**
 * LongestPlayingPairDto class
 */
public class LongestPlayingPairDto implements Comparable<LongestPlayingPairDto>{
    private String name;
    private int totalPlayTime;
    private String teamName;

    /**
     * Instantiates LongestPlayingPairDto
     */
    public LongestPlayingPairDto() {
    }

    /**
     * Instantiates LongestPlayingPairDto
     * @param name String object
     * @param totalPlayTime Integer value
     * @param teamName String object
     */
    public LongestPlayingPairDto(String name, int totalPlayTime, String teamName) {
        this.name = name;
        this.totalPlayTime = totalPlayTime;
        this.teamName = teamName;
    }

    /**
     * Return name
     * @return String object
     */
    public String getName() {
        return name;
    }

    /**
     * Update name
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return totalPlayTime
     * @return Integer value
     */
    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    /**
     * Update totalPlayTime
     * @param totalPlayTime Integer value
     */
    public void setTotalPlayTime(int totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    /**
     * Return teamName
     * @return String object
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Update teamName
     * @param teamName String object
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Converts object to String
     * @return String object
     */
    @Override
    public String toString() {
        return name + " / " + totalPlayTime +" / " + teamName ;
    }

    /**
     * Compare two LongestPlayingPairDto by totalPlayTime
     * @param o the object to be compared.
     * @return Integer value
     */
    @Override
    public int compareTo(LongestPlayingPairDto o) {
        return Integer.compare(o.getTotalPlayTime(), this.totalPlayTime);
    }
}
