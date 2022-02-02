package ch.bbbaden.yahtzee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class GameController {

    Results results = new Results();
    Game game = new Game();
    Sql sql = new Sql();
    Errormessage errormessage = new Errormessage();
    int counter = -1;
    Player player;
    int gameRoundsTotal = 0;
    int gameRoundsBonus = 0;
    String errorCounterIsZero = "Sie haben noch nicht gewürfelt.\n" +
            "Es wird nichts passieren.";

    @FXML
    private Label usernameLab;
    @FXML
    private Label highscoreLab;
    @FXML
    private Button rollTheDiceButton;
    @FXML
    private Button dice1Button;
    @FXML
    private Button dice2Button;
    @FXML
    private Button dice3Button;
    @FXML
    private Button dice4Button;
    @FXML
    private Button dice5Button;
    @FXML
    private Button einerBtn;
    @FXML
    private Label einerLbl;
    @FXML
    private Button zweierBtn;
    @FXML
    private Label zweierLbl;
    @FXML
    private Button dreierBtn;
    @FXML
    private Label dreierLbl;
    @FXML
    private Button viererBtn;
    @FXML
    private Label viererLbl;
    @FXML
    private Button fünferBtn;
    @FXML
    private Label fünferLbl;
    @FXML
    private Button sechserBtn;
    @FXML
    private Label sechserLbl;
    @FXML
    private Label bonusLbl;
    @FXML
    private Button einPaarBtn;
    @FXML
    private Label einPaarLbl;
    @FXML
    private Button zweiPaarBtn;
    @FXML
    private Label zweiPaarLbl;
    @FXML
    private Button dreiGleicheBtn;
    @FXML
    private Label dreiGleicheLbl;
    @FXML
    private Button vierGleicheBtn;
    @FXML
    private Label vierGleicheLbl;
    @FXML
    private Button kleineStrasseBtn;
    @FXML
    private Label kleineStrasseLbl;
    @FXML
    private Button grosseStrasseBtn;
    @FXML
    private Label grosseStrasseLbl;
    @FXML
    private Button vollesHausBtn;
    @FXML
    private Label vollesHausLbl;
    @FXML
    private Button chanceBtn;
    @FXML
    private Label chanceLbl;
    @FXML
    private Button yahtzeeBtn;
    @FXML
    private Label yahtzeeLbl;
    @FXML
    private Label totalLbl;
    @FXML
    private Button beendenBtn;
    @FXML
    private Button newGameBtn;
    ArrayList<Label> total = new ArrayList<>();
    ArrayList<Label> bonus = new ArrayList<>();

    public void setUpGameController(Player player) {
        this.player = player;
        usernameLab.setText(player.getName());
        highscoreLab.setText("Highscore: " + new Sql().getHighscore(player.getName()));
        bonus.add(einerLbl);
        bonus.add(zweierLbl);
        bonus.add(dreierLbl);
        bonus.add(viererLbl);
        bonus.add(fünferLbl);
        bonus.add(sechserLbl);
        total.add(einerLbl);
        total.add(zweierLbl);
        total.add(dreierLbl);
        total.add(viererLbl);
        total.add(fünferLbl);
        total.add(sechserLbl);
        total.add(einPaarLbl);
        total.add(zweiPaarLbl);
        total.add(dreiGleicheLbl);
        total.add(vierGleicheLbl);
        total.add(kleineStrasseLbl);
        total.add(grosseStrasseLbl);
        total.add(vollesHausLbl);
        total.add(chanceLbl);
        total.add(yahtzeeLbl);

        dice1Button.setStyle("-fx-background-color: default");
        dice2Button.setStyle("-fx-background-color: default");
        dice3Button.setStyle("-fx-background-color: default");
        dice4Button.setStyle("-fx-background-color: default");
        dice5Button.setStyle("-fx-background-color: default");
    }

    //Refreshes everything, checks if game is finished and hides dices
    public void refreshCounter() {
        counter = 0;
        gameRoundsTotal++;
        for (int i = 0; i < 5; i++) {
            Dice dice = game.getDiceFromIndex(i);
            if (dice.getIsLocked()) {
                dice.changeLockedStatus();
            }
        }

        dice1Button.setStyle("-fx-background-color: default");
        dice2Button.setStyle("-fx-background-color: default");
        dice3Button.setStyle("-fx-background-color: default");
        dice4Button.setStyle("-fx-background-color: default");
        dice5Button.setStyle("-fx-background-color: default");
        onBonusBtnClick(new ActionEvent());
        onTotalBtnClick(new ActionEvent());

        if (gameRoundsBonus == 6) {
            onBonusBtnClick(new ActionEvent());
        }
        if (gameRoundsTotal == 15) {
            beendenBtn.setVisible(true);
            newGameBtn.setVisible(true);
            player.setHighscore(Integer.valueOf(totalLbl.getText()));
            rollTheDiceButton.setVisible(false);
            player.countGamesPlayedUp();
            sql.updateHighscore(player.getName(), player.getHighscore());
            sql.updateGames(player.getName(), player.getGamesPlayed());
            sql.updateTotalPoints(player.getName(), player.getHighscore());
        }
        dice1Button.setVisible(false);
        dice2Button.setVisible(false);
        dice3Button.setVisible(false);
        dice4Button.setVisible(false);
        dice5Button.setVisible(false);
        dice1Button.setText("");
        dice2Button.setText("");
        dice3Button.setText("");
        dice4Button.setText("");
        dice5Button.setText("");
        for (Dice dices : game.getDices()) {
            game.setDicesToZero();
        }
    }

    //"Würfeln" - Button
    public void onRollTheDiceButtonClick(ActionEvent actionEvent) {
        if (counter == 0) {
            dice1Button.setVisible(true);
            dice2Button.setVisible(true);
            dice3Button.setVisible(true);
            dice4Button.setVisible(true);
            dice5Button.setVisible(true);
        }
        if (counter < 3) {
            game.rollEveryDice();
            HashSet<Dice> dices = game.getDices();
            dice1Button.setText(Integer.toString(game.getDiceFromIndex(0).getValueofDice()));
            dice2Button.setText(Integer.toString(game.getDiceFromIndex(1).getValueofDice()));
            dice3Button.setText(Integer.toString(game.getDiceFromIndex(2).getValueofDice()));
            dice4Button.setText(Integer.toString(game.getDiceFromIndex(3).getValueofDice()));
            dice5Button.setText(Integer.toString(game.getDiceFromIndex(4).getValueofDice()));
        } else {
            errormessage.getErrorMessage("Sie dürfen nicht mehr als 3 Mal würfeln.");
        }
        if (counter == -1) {
            dice1Button.setVisible(true);
            dice2Button.setVisible(true);
            dice3Button.setVisible(true);
            dice4Button.setVisible(true);
            dice5Button.setVisible(true);
            counter = 0;
        }
        counter++;
    }


    //Dice-Button
    public void onDice1ButtonClick(ActionEvent actionEvent) {
        int indexWeSearchFor = 0;
        Dice dice = game.getDiceFromIndex(indexWeSearchFor);
        dice.changeLockedStatus();
        if (dice.getIsLocked()) {
            dice1Button.setStyle("-fx-background-color: #808080");
        } else {
            dice1Button.setStyle("-fx-background-color: default");
        }
    }

    public void onDice2ButtonClick(ActionEvent actionEvent) {
        int indexWeSearchFor = 1;
        Dice dice = game.getDiceFromIndex(indexWeSearchFor);
        dice.changeLockedStatus();
        if (dice.getIsLocked()) {
            dice2Button.setStyle("-fx-background-color: #808080");
        } else {
            dice2Button.setStyle("-fx-background-color: default");
        }
    }

    public void onDice3ButtonClick(ActionEvent actionEvent) {
        int indexWeSearchFor = 2;
        Dice dice = game.getDiceFromIndex(indexWeSearchFor);
        dice.changeLockedStatus();
        if (dice.getIsLocked()) {
            dice3Button.setStyle("-fx-background-color: #808080");
        } else {
            dice3Button.setStyle("-fx-background-color: default");
        }
    }

    public void onDice4ButtonClick(ActionEvent actionEvent) {
        int indexWeSearchFor = 3;
        Dice dice = game.getDiceFromIndex(indexWeSearchFor);
        dice.changeLockedStatus();
        if (dice.getIsLocked()) {
            dice4Button.setStyle("-fx-background-color: #808080");
        } else {
            dice4Button.setStyle("-fx-background-color: default");
        }
    }

    public void onDice5ButtonClick(ActionEvent actionEvent) {
        int indexWeSearchFor = 4;
        Dice dice = game.getDiceFromIndex(indexWeSearchFor);
        dice.changeLockedStatus();
        if (dice.getIsLocked()) {
            dice5Button.setStyle("-fx-background-color: #808080");
        } else {
            dice5Button.setStyle("-fx-background-color: default");
        }
    }

    //Anleitung-Button
    public void onAnleitungsButtonClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Image icon = new Image("file:dice-icon.png");
        stage.getIcons().add(icon);
        alert.setTitle("Yahtzee Anleitung");
        alert.setContentText("Das Ziel des Spieles ist eine gewisse Kombination von Würfelaugenzahlen zu erreichen. " +
                "Falls eine Kombination ertüftelt wurde, kann diese über einen Knopfdruck des entsprechenden Resultatfeld " +
                "gespeichert werden. Es darf nur maximal drei Mal gewürfelt werden. Würfel können angeklickt werden, " +
                "um sie nicht mehr mitzuwürfeln. \n" +
                "Überall ist die Würfelaugenanzahl relevant für die Punkte, ausser bei den folgenden Resultaten: \n\n" +
                "Kleine Strasse 15 Punkte \n" +
                "Grosse Strasse 20 Punkte\n" +
                "Volles Haus 20 Punkte\n" +
                "Yahztee 50 Punkte\n\n" +
                "Der Bonus entspricht 25 und wird bei einer Punktezahl von 63 erreicht. \n");
        alert.getDialogPane().setMinHeight(Region.USE_COMPUTED_SIZE);
        alert.showAndWait();
    }


    //Point-Buttons
    public void onEinerBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 1);
            if (isResultOkay) {
                einerLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 1)));
                einerBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    einerLbl.setText("-");
                    einerBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onZweierBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 2);
            if (isResultOkay) {
                zweierLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 2)));
                zweierBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    zweierLbl.setText("-");
                    zweierBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onDreierBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 3);
            if (isResultOkay) {
                dreierLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 3)));
                dreierBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    dreierLbl.setText("-");
                    dreierBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onViererBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 4);
            if (isResultOkay) {
                viererLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 4)));
                viererBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    viererLbl.setText("-");
                    viererBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onFünferBtnCLick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 5);
            if (isResultOkay) {
                fünferLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 5)));
                fünferBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    fünferLbl.setText("-");
                    fünferBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onSechserBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isObererTeil(game.getDices(), 6);
            if (isResultOkay) {
                sechserLbl.setText(String.valueOf(results.countObererTeil(game.getDices(), 6)));
                sechserBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    sechserLbl.setText("-");
                    sechserBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
            gameRoundsBonus++;
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onEinPaarBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isOnePair(game.getDices());
            if (isResultOkay) {
                einPaarLbl.setText(String.valueOf(results.countOnePair(game.getDices())));
                einPaarBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    einPaarLbl.setText("-");
                    einPaarBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage((errorCounterIsZero));
        }
    }

    public void onZweiPaarBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isTwoPairs(game.getDices());
            if (isResultOkay) {
                zweiPaarLbl.setText(String.valueOf(results.countTwoPairs(game.getDices())));
                zweiPaarBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    zweiPaarLbl.setText("-");
                    zweiPaarBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onDreiGleicheBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isDreiGleiche(game.getDices());
            if (isResultOkay) {
                dreiGleicheLbl.setText(String.valueOf(results.countDreiGleiche(game.getDices())));
                dreiGleicheBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    dreiGleicheLbl.setText("-");
                    dreiGleicheBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onVierGleicheBtnCLick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isVierGleiche(game.getDices());
            if (isResultOkay) {
                vierGleicheLbl.setText(String.valueOf(results.countVierGleiche(game.getDices())));
                vierGleicheBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    vierGleicheLbl.setText("-");
                    vierGleicheBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onKleineStrasseBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isKleineStrasse(game.getDices());
            if (isResultOkay) {
                kleineStrasseLbl.setText("15");
                kleineStrasseBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    kleineStrasseLbl.setText("-");
                    kleineStrasseBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onGrosseStrasseBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isGrosseStrasse(game.getDices());
            if (isResultOkay) {
                grosseStrasseLbl.setText("20");
                grosseStrasseBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    grosseStrasseLbl.setText("-");
                    grosseStrasseBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onVollesHausBtnCLick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isFullHouse(game.getDices());
            if (isResultOkay) {
                vollesHausLbl.setText("20");
                vollesHausBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    vollesHausLbl.setText("-");
                    vollesHausBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onChanceBtnCLick(ActionEvent actionEvent) {
        if (counter > 0) {
            chanceLbl.setText(String.valueOf(results.countChance(game.getDices())));
            chanceBtn.setDisable(true);
            refreshCounter();
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    public void onYahtzeeBtnClick(ActionEvent actionEvent) {
        int reply = 0;
        if (counter > 0) {
            boolean isResultOkay = results.isYahtzee(game.getDices());
            if (isResultOkay) {
                yahtzeeLbl.setText("50");
                yahtzeeBtn.setDisable(true);
            } else {
                reply = errormessage.getYesNoMessage();
                if (reply == JOptionPane.YES_OPTION) {
                    yahtzeeLbl.setText("-");
                    yahtzeeBtn.setDisable(true);
                }
            }
            if(reply == JOptionPane.YES_OPTION) {
                refreshCounter();
            }
        } else {
            errormessage.getErrorMessage(errorCounterIsZero);
        }
    }

    //Refreshes bonus field
    public boolean onBonusBtnClick(ActionEvent actionEvent) {
        int bonusTotoal = 0;
        for (Label label : bonus) {
            if (label.getText() == "-" || label.getText() == "") {
            } else {
                bonusTotoal += Integer.valueOf(label.getText());
            }
        }
        if (bonusTotoal >= 63) {
            bonusLbl.setText("25");
            return true;
        } else {
            bonusLbl.setText(bonusTotoal + " von 63");
            return false;
        }
    }

    //Refreshes total field
    public void onTotalBtnClick(ActionEvent actionEvent) {
        int totalTotal = 0;
        for (Label label : total) {
            if (label.getText() == "-" || label.getText() == "") {
            } else {
                totalTotal += Integer.valueOf(label.getText());
            }
        }
        if (onBonusBtnClick(actionEvent) == true) {
            totalTotal += 25;
        }
        totalLbl.setText(String.valueOf(totalTotal));
    }

    //Ends game
    public void onBeendenBtnClick(ActionEvent event) {
        try {
            Stage stage;
            FXMLLoader fxmlLoader = new FXMLLoader(YahtzeeApplication.class.getResource("LoginScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = new Stage();
            stage.setTitle("Login");
            Image icon = new Image("file:dice-icon.png");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Go to Hall Of Fame
    public void onHofBtnClick(ActionEvent event) {
        try {
            Stage stage;
            FXMLLoader fxmlLoader = new FXMLLoader(YahtzeeApplication.class.getResource("HOFScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image icon = new Image("file:dice-icon.png");
            stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle("Hall Of Fame");
            stage.setScene(scene);
            stage.show();
            HOFController hofController = fxmlLoader.getController();
            hofController.HOFController(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load new game
    public void onNewGameBtnClick(ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(YahtzeeApplication.class.getResource("GameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = new Stage();
        Image icon = new Image("file:dice-icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
        GameController gameController = fxmlLoader.getController();
        gameController.setUpGameController(player);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
