package com.example.bundesligatabellemysql;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

// Importieren der benötigten Klassen und Pakete

public class AddTabelleController implements Initializable {
    // Deklaration von Variablen und Steuerelementen (Textfelder) als FXML-Elemente

    @FXML
    private TextField gegentoreFid;

    @FXML
    private TextField niederlagenFid;

    @FXML
    private TextField siegeFid;

    @FXML
    private TextField spieleFid;

    @FXML
    private TextField toreFid;

    @FXML
    private TextField unentschiedenFid;

    @FXML
    private TextField vereinFid;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Bundesliga bundesliga = null;
    private boolean aktualisieren;
    int spiele;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    // Initialisierungsmethode für den Controller

    @FXML
    void clear(ContextMenuEvent event) {
    }
    // Event-Handler-Methode für das Löschen von Daten

    @FXML
    void speichern(MouseEvent event) {
        // Event-Handler-Methode für das Speichern von Daten

        connection = DbVerbindung.getConnect();
        // Herstellen der Verbindung zur Datenbank

        String Verein = vereinFid.getText();
        String Spiele = spieleFid.getText();
        String Siege = siegeFid.getText();
        String Niederlagen = spieleFid.getText();
        String Unentschieden = unentschiedenFid.getText();
        String Tore = toreFid.getText();
        String Gegentore = gegentoreFid.getText();
        // Abrufen der eingegebenen Daten aus den Textfeldern

        if (Verein.isEmpty() || Spiele.isEmpty() || Siege.isEmpty() || Niederlagen.isEmpty() || Unentschieden.isEmpty() || Tore.isEmpty() || Gegentore.isEmpty()) {
            // Überprüfen, ob alle Textfelder ausgefüllt sind
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Bitte füllen Sie die Daten aus");
            alert.showAndWait();
        } else {
            getQuery();
            // Aufrufen der Methode, um die entsprechende SQL-Abfrage zu erhalten
            insert();
            // Einfügen der Daten in die Datenbanktabelle
            leeren();
            // Zurücksetzen der Textfelder auf den Ausgangszustand
        }
    }

    @FXML
    private void leeren() {
        // Methode zum Zurücksetzen der Textfelder
        vereinFid.setText(null);
        spieleFid.setText(null);
        siegeFid.setText(null);
        niederlagenFid.setText(null);
        unentschiedenFid.setText(null);
        toreFid.setText(null);
        gegentoreFid.setText(null);
    }

    private void insert() {
        // Methode zum Einfügen der Daten in die Datenbanktabelle
        try {
            preparedStatement = connection.prepareStatement((query));
            preparedStatement.setString(1,vereinFid.getText());
            preparedStatement.setString(2,spieleFid.getText());
            preparedStatement.setString(3,siegeFid.getText());
            preparedStatement.setString(4,niederlagenFid.getText());
            preparedStatement.setString(5,unentschiedenFid.getText());
            preparedStatement.setString(6,toreFid.getText());
            preparedStatement.setString(7,gegentoreFid.getText());
            if (aktualisieren)
                preparedStatement.setString(8, vereinFid.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            Logger.getLogger(AddTabelleController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private void getQuery() {
        // Methode zum Erstellen der SQL-Abfrage basierend auf dem Status der Aktualisierung
        if (aktualisieren == false) {
            query = "INSERT INTO tabelle (Verein, Spiele, Siege, Niederlagen, Unentschieden, Tore, Gegentore) VALUES (?,?,?,?,?,?,?)";
        } else {
            query = "UPDATE tabelle SET "
                    + "`Verein`=?,"
                    + "`Spiele`=?,"
                    + "`Siege`=?,"
                    + "`Niederlagen`=?,"
                    + "`Unentschieden`=?,"
                    + "`Tore`=?,"
                    + "`Gegentore`=?"
                    + "WHERE Verein = ?";
        }
    }

    void setTextField(String verein, int spiele, int siege, int niederlagen, int unentschieden, int tore, int gegentore) {
        // Methode zum Setzen der Textfelder mit übergebenen Werten
        vereinFid.setText(verein);
        spieleFid.setText(String.valueOf(spiele));
        siegeFid.setText(String.valueOf(siege));
        niederlagenFid.setText(String.valueOf(niederlagen));
        unentschiedenFid.setText(String.valueOf(unentschieden));
        toreFid.setText(String.valueOf(tore));
        gegentoreFid.setText(String.valueOf(gegentore));
    }

    void setUpdate(boolean b) {
        // Methode zum Setzen des Aktualisierungsstatus
        this.aktualisieren = b;
    }
}
/*
Dieser Code enthält Funktionen, um Daten aus den Textfeldern abzurufen, sie in einer Datenbank zu speichern
und die Textfelder zurückzusetzen. Es gibt auch Methoden zum Erstellen der SQL-Abfrage
basierend auf dem Aktualisierungsstatus und zum Setzen der Textfelder mit übergebenen Werten.
 */