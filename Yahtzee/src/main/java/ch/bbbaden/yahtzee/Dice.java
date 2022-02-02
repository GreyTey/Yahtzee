package ch.bbbaden.yahtzee;

import java.util.Random;

public class Dice {
    private boolean isLocked = false;
    private int valueOfDice;

    //For tests
    public Dice(int valueofDice) {
        this.valueOfDice = valueofDice;
    }

    //Empty constructor
    public Dice() {
    }

    public void rollTheDice() {
        if (!getIsLocked()) {
            Random rnd = new Random();
            valueOfDice = rnd.nextInt(6) + 1;
        }
    }

    //For locking dices
    public void changeLockedStatus() {
        if (isLocked) {
            isLocked = false;
        } else {
            isLocked = true;
        }
    }

    public void setValueofDiceToZero() {
        valueOfDice = 0;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public int getValueofDice() {
        return valueOfDice;
    }
}
