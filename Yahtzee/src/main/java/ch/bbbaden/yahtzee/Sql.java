package ch.bbbaden.yahtzee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;

public class Sql{
    Connection c = null;
    Statement stmt = null;
    Errormessage javaFx = new Errormessage();
    boolean wasSuccessful = false;

        public boolean createTableIfNotExists(){
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS users " +
                        "(username TEXT PRIMARY KEY     NOT NULL," +
                        " password           TEXT    NOT NULL, " +
                        "highscore INTEGER DEFAULT (0)," +
                        "games     INTEGER DEFAULT (0)," +
                        "totalpoints INTEGER DEFAULT (0));";
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
                wasSuccessful = true;
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
                wasSuccessful = false;
            }
            System.out.println("Table created successfully");
            return wasSuccessful;
        }


        public boolean insertNewUser(String username, String password) {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
                c.setAutoCommit(false);
                stmt = c.createStatement();
                String sql = "INSERT INTO users (username, password) " +
                        "VALUES ('" + username + "','" + password + "');";
                stmt.executeUpdate(sql);
                c.commit();
                c.close();
                wasSuccessful = true;
            }catch (Exception e){
                javaFx.getErrorMessage("Dieser Username existiert bereits.");
                wasSuccessful = false;
            }
            return wasSuccessful;
        }

    public boolean updateTotalPoints(String username, int newScore){
            try{
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "UPDATE users SET totalpoints = totalpoints + " + newScore + " WHERE username='" + username + "';";
                stmt.executeUpdate(sql);
                c.commit();
                stmt.close();
                c.close();
                wasSuccessful = true;
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
                wasSuccessful = false;
            }
            System.out.println("Operation done successfully");
            return wasSuccessful;
    }

    public boolean updateHighscore(String username, int highscore){
        if (Integer.valueOf(getHighscore(username)) < highscore) {
            try{
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "UPDATE users SET highscore = " + highscore + " WHERE username='" + username + "';";
                stmt.executeUpdate(sql);
                c.commit();
                stmt.close();
                c.close();
                wasSuccessful = true;
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
                wasSuccessful = false;
            }
            System.out.println("Operation done successfully");

        }
        return wasSuccessful;
    }

    public boolean updateGames(String username, int games){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE users SET games = " + games + " WHERE username='" + username + "';";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
            wasSuccessful = true;
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return wasSuccessful;
    }

    public String selectUser(String username) {
        String password = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "';");

            while (rs.next()) {
                password = rs.getString("password");
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return password;
    }

    public String getHighscore(String username) {
        String strHighscore = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "';");

            while (rs.next()) {
                strHighscore = rs.getString("highscore");
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return strHighscore;
    }

    public String getGames(String username) {
        String strGames = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "';");

            while (rs.next()) {
                strGames = rs.getString("games");
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return strGames;
    }

    public String getTotalPoints(String username) {
        String strTotalPoints = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "';");

            while (rs.next()) {
                strTotalPoints = rs.getString("totalpoints");
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return strTotalPoints;
    }

    public boolean doesUserExist(String username){
        ArrayList<String> users = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + username + "';");

            while (rs.next()) {
                users.add(rs.getString("username"));
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        if(users.size() == 1){
            return true;
        } else {
            return false;
        }
    }

    public ObservableList<Person> getAllPlayersAsPersons(){
            ObservableList<Person> allPlayers = FXCollections.observableArrayList();
            String username = "";
            String password = "";
            int highscore = 0;
            int gamesPlayed = 0;
            int totalpoints = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");

            while (rs.next()) {
                username = rs.getString("username");
                highscore = rs.getInt("highscore");
                gamesPlayed = rs.getInt("games");
                totalpoints = rs.getInt("totalpoints");
                allPlayers.add(new Person(username, gamesPlayed, highscore, totalpoints));
            }
            rs.close();
            stmt.close();
            c.close();
            wasSuccessful = true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            wasSuccessful = false;
        }
        System.out.println("Operation done successfully");
        return allPlayers;
    }
}
