package ch.bbbaden.yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Results {
    /**
     *Calculating what results are possible with the dices.
     */


    public int countObererTeil(HashSet<Dice> dices, int diceNumber) {
        ArrayList<Integer> value = new ArrayList<>();
        int result = 0;
        for (Dice dice : dices) {
            int valueOfDice = dice.getValueofDice();
            if (diceNumber == valueOfDice) {
                result += diceNumber;
            }
        }
        return result;
    }

    public int countChance(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        int result = 0;
        for (Dice dice : dices) {
            result += dice.getValueofDice();
        }
        return result;
    }

    public int countDreiGleiche(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        int result = 0;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
            for (int i = 1; i <= 6; i++) {
                int count = Collections.frequency(value, i);
                if (count >= 3) {
                    result = 3 * i;
                }
            }
        }
        return result;
    }

    public int countVierGleiche(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        int result = 0;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
            for (int i = 1; i <= 6; i++) {
                int count = Collections.frequency(value, i);
                if (count >= 4) {
                    result = 4 * i;
                }
            }
        }
        return result;
    }

    public int countOnePair(HashSet<Dice> dices) {
        ArrayList<Integer> values = new ArrayList<>();
        for (Dice dice : dices) {
            values.add(dice.getValueofDice());
        }
        int biggestValue = 0;
        for (int i = 6; i >= 1; i--) {
            int countValues = 0;
            int countNumbers = 0;
            for (Integer number : values) {
                if (i == number) {
                    countValues += number;
                    countNumbers++;
                }
            }

            if (countNumbers >= 2) {
                if ((countValues / countNumbers) * 2 >= biggestValue) {
                    biggestValue = i * 2;
                }
            }
        }
        return biggestValue;
    }

    public int countTwoPairs(HashSet<Dice> dices) {
        ArrayList<Integer> values = new ArrayList<>();
        for (Dice dice : dices) {
            values.add(dice.getValueofDice());
        }
        int biggestValue = 0;
        int secondValue = 0;
        for (int i = 6; i >= 1; i--) {
            int countValues = 0;
            int countNumbers = 0;
            for (Integer number : values) {
                if (i == number) {
                    countValues += number;
                }
            }
            if(countValues >= i * 4){
                return i * 4;
            }
            if (countValues >= i * 2) {
                if (countValues >= biggestValue) {
                    biggestValue = i * 2;
                } else if (countValues >= secondValue) {
                    secondValue = i * 2;
                }
            }
        }
        return biggestValue + secondValue;
    }

    public boolean isObererTeil(HashSet<Dice> dices, int diceNumber) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result = false;
        for (Dice dice : dices) {
            int valueOfDice = dice.getValueofDice();
            if (diceNumber == valueOfDice) {
                result = true;
            }
        }
        return result;
    }

    public boolean isKleineStrasse(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
        }
        if (value.contains(1) && value.contains(2) && value.contains(3) && value.contains(4)) {
            result = true;
        } else if (value.contains(2) && value.contains(3) && value.contains(4) && value.contains(5)) {
            result = true;
        } else if (value.contains(3) && value.contains(4) && value.contains(5) && value.contains(6)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isGrosseStrasse(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
        }
        if (value.contains(1) && value.contains(2) && value.contains(3) && value.contains(4) && value.contains(5)) {
            result = true;
        } else if (value.contains(2) && value.contains(3) && value.contains(4) && value.contains(5) && value.contains(5)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isDreiGleiche(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result = false;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
        }
        for (int i = 1; i <= 6; i++) {
            int count = Collections.frequency(value, i);
            if (count >= 3) {
                result = true;
            }
        }
        return result;
    }

    public boolean isVierGleiche(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result = false;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
        }
        for (int i = 1; i <= 6; i++) {
            int count = Collections.frequency(value, i);
            if (count >= 4) {
                result = true;
            }
        }
        return result;
    }

    public boolean isYahtzee(HashSet<Dice> dices) {
        ArrayList<Integer> value = new ArrayList<>();
        boolean result = false;
        for (Dice dice : dices) {
            value.add(dice.getValueofDice());
        }
        for (int i = 1; i <= 6; i++) {
            int count = Collections.frequency(value, i);
            if (count == 5) {
                result = true;
            }
        }
        return result;
    }

    public boolean isFullHouse(HashSet<Dice> dices) {
        boolean isFullHouse = false;
        for (int d1 = 1; d1 <= 6; d1++) {
            for (int d2 = 1; d2 <= 6; d2++) {
                if (d1 != d2) {
                    int sameAsD1 = 0;
                    int sameAsD2 = 0;
                    for (Dice dice : dices) {
                        if (dice.getValueofDice() == d1) {
                            sameAsD1++;
                        } else if (dice.getValueofDice() == d2) {
                            sameAsD2++;
                        }
                    }
                    if (sameAsD1 == 3 && sameAsD2 == 2) {
                        isFullHouse = true;
                    } else if (sameAsD1 == 2 && sameAsD2 == 3) {
                        isFullHouse = true;
                    }
                }
            }
        }
        return isFullHouse;
    }

    public boolean isOnePair(HashSet<Dice> dices) {
        int paare = 0;
        for (Dice zahl : dices) {
            int gleicheZahl = 0;
            for (Dice vergleichsWürfel : dices) {
                if (zahl.getValueofDice() == vergleichsWürfel.getValueofDice() && zahl.getValueofDice() != 0) {
                    gleicheZahl++;
                }
            }
            gleicheZahl -= 1;
            if (gleicheZahl >= 1) {
                paare++;
            }
        }
        if (paare >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTwoPairs(HashSet<Dice> dices) {
        int paare = 0;
        for (Dice zahl : dices) {
            int gleicheZahl = 0;
            for (Dice vergleichsWürfel : dices) {
                if (zahl.getValueofDice() == vergleichsWürfel.getValueofDice() && zahl.getValueofDice() != 0) {
                    gleicheZahl++;
                }
            }
            gleicheZahl -= 1;
            if (gleicheZahl >= 1 && gleicheZahl <= 2) {
                paare++;
            } else if (gleicheZahl >= 3) {
                paare += 2;
            }
        }
        if (paare >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
