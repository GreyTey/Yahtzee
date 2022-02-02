package ch.bbbaden.yahtzee;

public class Login {
    private static final char colon = ':';
    private static final char space = ' ';
    private Player player = null;
    private boolean canGameStart = false;
    private Errormessage message = new Errormessage();

    public Login(String username, String userPassword, String userPasswordForValidation) {
        new Sql().createTableIfNotExists();
        boolean usernameCorrect = true;
        if (userPasswordForValidation == null) {
            //Login
            player = this.anmelden(username, userPassword);
        } else if (userPassword.equals(userPasswordForValidation)) {
            //Registration
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) == colon || username.charAt(i) == space) {
                    usernameCorrect = false;
                }
            }
            for (int i = 0; i < userPassword.length(); i++) {
                if (userPassword.charAt(i) == colon || userPassword.charAt(i) == space) {
                    usernameCorrect = false;
                }
            }
            if (usernameCorrect && userPassword != null && username != null) {
                canGameStart = new Sql().insertNewUser(username, userPassword);
                player = new Player(username, userPassword);

            } else {
                message.getErrorMessage("Ungültige Zeichen enthalten\nBitte Username und/oder Passwort ändern.");
                canGameStart = false;
            }
        } else {
            message.getErrorMessage("Die Passwörter stimmen nicht überein.\nBitte versuche es erneut.");
            canGameStart = false;
        }
    }

    public Player anmelden(String username, String userPassword) {
        Player player = null;
        String password = null;
        if (username != null && new Sql().doesUserExist(username) == true) {
            Sql abfrage = new Sql();
            password = abfrage.selectUser(username);
            canGameStart = abfrage.wasSuccessful;
            if (password.equals(userPassword) && canGameStart) {
                player = new Player(username, userPassword);
                canGameStart = true;
            } else {
                message.getErrorMessage("Falsches Passwort.\nVersuchen Sie es erneut.");
                canGameStart = false;

            }
        } else {
            message.getErrorMessage("Dieser User existiert nicht.");
            canGameStart = false;
        }
        return player;
    }

    public boolean getCanGameStart() {
        return canGameStart;
    }

    public Player getPlayer() {
        return player;
    }
}
