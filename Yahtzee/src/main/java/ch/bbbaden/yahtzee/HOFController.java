package ch.bbbaden.yahtzee;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Collections;
import java.util.Comparator;

public class HOFController {

    @FXML
    private TableView<Person> tableHOF = new TableView<>();
    @FXML
    private TableColumn<Person, String> tableUsername = new TableColumn<>();
    @FXML
    private TableColumn<Person, Integer> tableHighscore = new TableColumn<>();
    @FXML
    private TableColumn<Person, Integer> tableDurPunkte = new TableColumn<>();
    @FXML
    private TableColumn<Person, Integer> tableSpiele = new TableColumn<>();

    public void HOFController(Player player) {
        Sql setItems = new Sql();
        tableUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tableHighscore.setCellValueFactory(new PropertyValueFactory<>("highscore"));
        tableDurPunkte.setCellValueFactory(new PropertyValueFactory<>("averageScorePerGame"));
        tableSpiele.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));
        ObservableList<Person> allPlayers = setItems.getAllPlayersAsPersons();
        Comparator<Person> comparator = Comparator.comparing(Person::getHighscore);
        Comparator<Person> reversedComparator = comparator.reversed();
        allPlayers.sort(reversedComparator);
        tableHOF.setItems(allPlayers);
    }


    public void onZurueckBtnClick(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
