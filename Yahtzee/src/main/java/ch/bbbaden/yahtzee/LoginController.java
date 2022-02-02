package ch.bbbaden.yahtzee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class LoginController {

    //Variablen
    private boolean isAnmelden = true;
    private Player player;

    //FXML Elemente
    @FXML
    private Label secpassLab;
    @FXML
    private TextField nameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField secpassField;
    @FXML
    private Button switchButton;
    @FXML
    private Button startGame;


    //Login View
    @FXML
    protected void onSwitchLoginButtonClick() {

        if (!isAnmelden) {
            switchButton.setText("Schon ein Konto? Anmelden!");
            secpassLab.setVisible(true);
            secpassField.setVisible(true);
            startGame.setText("Registrieren");

        } else {
            switchButton.setText("Noch kein Konto? Registriere dich!");
            secpassLab.setVisible(false);
            secpassField.setVisible(false);
            secpassField.setText(null);
            startGame.setText("Anmelden");
        }
        isAnmelden = !isAnmelden;
    }


    //Game View
    @FXML
    public void onStartGameButtonClick(ActionEvent event) throws IOException {
        if (switchButton.getText() =="Noch kein Konto? Registriere dich!"){
            secpassField.setText(null);
        }
        Stage stage;
        Login login = new Login(nameField.getText(), passwordField.getText(), secpassField.getText());
        player = login.getPlayer();
        if (login.getCanGameStart()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(YahtzeeApplication.class.getResource("GameScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage = new Stage();
                Image icon = new Image("file:dice-icon.png");
                stage.getIcons().add(icon);
                stage.setTitle("Game");
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
                GameController gameController = fxmlLoader.getController();
                gameController.setUpGameController(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            nameField.clear();
            passwordField.clear();
            secpassField.clear();
        }
    }
}