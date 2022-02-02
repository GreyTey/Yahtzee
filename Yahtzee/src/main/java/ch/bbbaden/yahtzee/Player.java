package ch.bbbaden.yahtzee;

public class Player {
    private final String username;
    private final String userPassword;
    private int highscore = 0;
    private int gamesPlayed = 0;
    private int averageScorePerGame = 0;
    private int totalpoints = 0;

    public Player(String loginName, String password) {
        Sql eintrag = new Sql();
        this.username = loginName;
        this.userPassword = password;
        setHighscore(Integer.valueOf(eintrag.getHighscore(loginName)));
        setGamesPlayed(Integer.valueOf(eintrag.getGames(loginName)));
        setTotalpoints(Integer.valueOf(eintrag.getTotalPoints(loginName)));
        setAverageScorePerGame();
    }

    public String getName() {
        return username;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
        setTotalpoints(highscore);
    }

    public int getHighscore() {
        return highscore;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        setAverageScorePerGame();
    }

    public void countGamesPlayedUp() {
        this.gamesPlayed++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setTotalpoints(int additionalScore) {
        this.totalpoints += additionalScore;
        setAverageScorePerGame();
    }

    public void setAverageScorePerGame() {
        if (gamesPlayed != 0) {
            averageScorePerGame = totalpoints / gamesPlayed;
        }
    }


}
