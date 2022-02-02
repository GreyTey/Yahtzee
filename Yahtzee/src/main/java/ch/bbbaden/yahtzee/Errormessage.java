package ch.bbbaden.yahtzee;

import javax.swing.*;

public class Errormessage {

    public void getErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int getYesNoMessage() {
        int reply = JOptionPane.showConfirmDialog(null, "Möchten sie dieses Feld Streichen?", "Streichen?", JOptionPane.YES_NO_OPTION);
        return reply;
    }
}
