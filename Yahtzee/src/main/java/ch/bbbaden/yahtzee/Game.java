package ch.bbbaden.yahtzee;

import java.util.HashSet;

public class Game {
    protected HashSet<Dice> dices = new HashSet<>();

    public Game() {
        for (int i = 0; i < 5; i++) {
            dices.add(new Dice());
        }
        new Sql().createTableIfNotExists();
    }

    public HashSet<Dice> getDices() {
        HashSet<Dice> diceHashSet = dices;
        return diceHashSet;
    }

    public void rollEveryDice() {
        for (Dice dice : dices) {
            if (dice.getIsLocked() == false) {
                dice.rollTheDice();
            }
        }
    }

    public Dice getDiceFromIndex(int indexOfItem) {
        int index = 0;
        Dice diceToReturn = null;
        for (Dice dice : dices) {
            if (index == indexOfItem) {
                diceToReturn = dice;
            }
            index++;
        }
        return diceToReturn;
    }

    public void setDicesToZero() {
        for (Dice dice : dices) {
            if (dice.getIsLocked() == false) {
                dice.setValueofDiceToZero();
            }
        }
    }
}
