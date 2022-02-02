package ch.bbbaden.yahtzee;

public class Person {
    /**
     * Class for TableView
     */
    private String username = null;
    private int gamesPlayed = 0;
    private int averageScorePerGame = 0;
    private int highscore = 0;
    private int totalpoints = 0;

    public Person() {
    }

    public Person(String username, int gamesPlayed, int highscore, int totalpoints) {
        this.username = username;
        this.gamesPlayed = gamesPlayed;
        this.highscore = highscore;
        this.totalpoints = totalpoints;
        if(gamesPlayed != 0) {
            this.averageScorePerGame = totalpoints / gamesPlayed;
        }else{ this.averageScorePerGame = 0;}
    }

    public String getUsername() {
        return username;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getAverageScorePerGame() {
        return averageScorePerGame;
    }

    public int getHighscore() {
        return highscore;
    }

    public int getTotalpoints() { return totalpoints; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setAverageScorePerGame(int averageScorePerGame) {
        this.averageScorePerGame = averageScorePerGame;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public void setTotalpoints(int totalpoints) { this.totalpoints = totalpoints; }
}
