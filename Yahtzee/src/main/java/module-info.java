module ch.bbbaden.yahtzee {
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.controls;

    opens ch.bbbaden.yahtzee to javafx.fxml;
    exports ch.bbbaden.yahtzee;
}