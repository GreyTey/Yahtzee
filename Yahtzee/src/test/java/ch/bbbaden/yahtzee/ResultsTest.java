package ch.bbbaden.yahtzee;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {

    //Drei Gleiche (5,5,5,6,6)
    @Test
    void countDreiGleicheTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countDreiGleiche(testSet);

        //Assert
        assertEquals(15, ist);

    }

    //Drei Gleiche (5,5,6,6,6)
    @Test
    void countDreiGleicheTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(4));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countDreiGleiche(testSet);

        //Assert
        assertEquals(0, ist);

    }

    //Vier Gleiche (5,5,5,5,6)
    @Test
    void countVierGleicheTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countVierGleiche(testSet);

        //Assert
        assertEquals(20, ist);

    }

    //Vier Gleiche (5,5,5,6,6)
    @Test
    void countVierGleicheTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countVierGleiche(testSet);

        //Assert
        assertEquals(0, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countChanceTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countChance(testSet);

        //Assert
        assertEquals(15, ist);

    }

    //Oberer Teil (1,2,3,6,6)
    @Test
    void countChanceTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countChance(testSet);

        //Assert
        assertEquals(18, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 1);

        //Assert
        assertEquals(1, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 2);

        //Assert
        assertEquals(2, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest3() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 3);

        //Assert
        assertEquals(3, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest4() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 4);

        //Assert
        assertEquals(4, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest5() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 5);

        //Assert
        assertEquals(5, ist);

    }

    //Oberer Teil (1,2,3,6,6)
    @Test
    void countObererTeilTest6() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 6);

        //Assert
        assertEquals(12, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void countObererTeilTest7() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countObererTeil(testSet, 6);

        //Assert
        assertEquals(0, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 1);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 2);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest3() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 3);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest4() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 4);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest5() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 5);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,6,6)
    @Test
    void isObererTeilTest6() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(6));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 6);

        //Assert
        assertEquals(true, ist);

    }

    //Oberer Teil (1,2,3,4,5)
    @Test
    void isObererTeilTest7() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isObererTeil(testSet, 6);

        //Assert
        assertEquals(false, ist);

    }

    //Kein Fullhouse (2,3,4,4,5)
    @Test
    void isFullHouseTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isFullHouse(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //Fullhouse (3,3,4,4,4)
    @Test
    void isFullHouseTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isFullHouse(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Fullhouse (3,3,3,4,4)
    @Test
    void isFullHouseTest3() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isFullHouse(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Kein Fullhouse (1,1,3,4,4)
    @Test
    void isFullHouseTest4() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(1));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isFullHouse(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //2 Paare(1,1,3,4,4)
    @Test
    void isOnePairTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(1));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isOnePair(testSet);

        //Assert
        assertEquals(true, ist);
    }

    //Ein Paar (2,3,4,4,5)
    @Test
    void isOnePairTest2(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isOnePair(testSet);

        //Assert
        assertEquals(true, ist);
    }

    //Ein Paar (3,3,3,4,4)
    @Test
    void isOnePairTest3(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isOnePair(testSet);

        //Assert
        assertEquals(true, ist);

    }
    //Ein Paar (3,3,3,4,4)
    @Test
    void countOnePairTest1(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countOnePair(testSet);

        //Assert
        assertEquals(8, ist);

    }

    @Test
    void countOnePairTest3(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(2));
        testSet.add(new Dice(2));
        testSet.add(new Dice(2));
        testSet.add(new Dice(2));
        testSet.add(new Dice(1));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countOnePair(testSet);

        //Assert
        assertEquals(4, ist);

    }

    @Test
    void countOneTwoTest1(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(4));
        testSet.add(new Dice(1));
        testSet.add(new Dice(4));
        testSet.add(new Dice(1));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countTwoPairs(testSet);

        //Assert
        assertEquals(10, ist);

    }

    @Test
    void countOnePairTest2(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(3));
        testSet.add(new Dice(5));
        testSet.add(new Dice(1));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countOnePair(testSet);

        //Assert
        assertEquals(6, ist);

    }

    @Test
    void countOneTwoTest2(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(3));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        int ist = testResultate.countTwoPairs(testSet);

        //Assert
        assertEquals(16, ist);

    }

    //2 Paare(1,1,3,4,4)
    @Test
    void isTwoPairsTest1(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(1));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isTwoPairs(testSet);

        //Assert
        assertEquals(true, ist);
    }

    //Ein Paar (2,3,4,4,5)
    @Test
    void isTwoPairsTest2(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isTwoPairs(testSet);

        //Assert
        assertEquals(false, ist);
    }

    //Ein Paar (3,3,3,4,4)
    @Test
    void isTwoPairsTest3(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isTwoPairs(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Zwei Paare (3,3,3,3,4)
    @Test
    void isTwoPairsTest4(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isTwoPairs(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Drei Gleiche (1,2,2,2,5)
    @Test
    void isDreiGleicheTest1(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(2));
        testSet.add(new Dice(2));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isDreiGleiche(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Drei Gleiche (1,1,2,3,4)
    @Test
    void isDreiGleicheTest2(){
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isDreiGleiche(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //Ist Strasse(1,2,3,4,2)
    @Test
    void isKleineStrasseTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(2));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isKleineStrasse(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Keine Strasse (1,3,3,4,5)
    @Test
    void isKleineStrasseTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isKleineStrasse(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //Grosse Strasse (1,2,3,4,5)
    @Test
    void isGrosseStrasseTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(2));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isGrosseStrasse(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Grosse Strasse (1,3,3,4,5)
    @Test
    void isGrosseStrasseTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(1));
        testSet.add(new Dice(3));
        testSet.add(new Dice(3));
        testSet.add(new Dice(4));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isGrosseStrasse(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //Vier Gleiche (5,5,5,5,6)
    @Test
    void isVierGleicheTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isVierGleiche(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Vier Gleiche (5,5,5,4,6)
    @Test
    void isVierGleicheTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(4));
        testSet.add(new Dice(6));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isVierGleiche(testSet);

        //Assert
        assertEquals(false, ist);

    }

    //Yahtzee (5,5,5,5,5)
    @Test
    void isYahtzeeTest1() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isYahtzee(testSet);

        //Assert
        assertEquals(true, ist);

    }

    //Yahtzee (5,5,5,5,2)
    @Test
    void isYahtzeeTest2() {
        //Arrange
        HashSet<Dice> testSet = new HashSet<Dice>();
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(5));
        testSet.add(new Dice(2));
        Results testResultate = new Results();

        //Act
        boolean ist = testResultate.isYahtzee(testSet);

        //Assert
        assertEquals(false, ist);

    }
}