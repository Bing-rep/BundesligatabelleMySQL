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

public class AddTabelleController implements Initializable {

    @FXML
    private JFXTextField gegentoreFid;

    @FXML
    private JFXTextField niederlagenFid;

    @FXML
    private JFXTextField punkteFid;

    @FXML
    private JFXTextField siegeFid;

    @FXML
    private JFXTextField spieleFid;

    @FXML
    private JFXTextField toreFid;

    @FXML
    private JFXTextField unentschiedenFid;

    @FXML
    private JFXTextField vereinFid;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Bundesliga bundesliga = null;
    private boolean aktualisieren;
    int spiele;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    void clear(ContextMenuEvent event) {

    }

    @FXML
    void speichern(MouseEvent event) {

        connection = DbVerbindung.getConnect();
        String Verein = vereinFid.getText();
        String Spiele = spieleFid.getText();
        String Siege = siegeFid.getText();
        String Niederlagen = spieleFid.getText();
        String Unentschieden = unentschiedenFid.getText();
        String Tore = toreFid.getText();
        String Gegentore = gegentoreFid.getText();
        String Punkte = punkteFid.getText();

        if (Verein.isEmpty() | Spiele.isEmpty()| Siege.isEmpty()| Niederlagen.isEmpty()| Unentschieden.isEmpty()| Tore.isEmpty()| Gegentore.isEmpty()| Punkte.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Bitte füllen sie die Daten aus");
            alert.showAndWait();

        }else{
            getQuery();
            insert();
            leeren();
        }

    }

    @FXML
    private  void leeren() {
        vereinFid.setText(null);
        spieleFid.setText(null);
        siegeFid.setText(null);
        niederlagenFid.setText(null);
        unentschiedenFid.setText(null);
        toreFid.setText(null);
        gegentoreFid.setText(null);
        punkteFid.setText(null);

    }
    private void insert() {

        try {
            preparedStatement = connection.prepareStatement((query));
            preparedStatement.setString(1, vereinFid.getText());
            preparedStatement.setString(1, spieleFid.getText());
            preparedStatement.setInt(3, Integer.parseInt(siegeFid.getText()));
            preparedStatement.setInt(4, Integer.parseInt(niederlagenFid.getText()));
            preparedStatement.setInt(5, Integer.parseInt(unentschiedenFid.getText()));
            preparedStatement.setInt(6, Integer.parseInt(toreFid.getText()));
            preparedStatement.setInt(7, Integer.parseInt(gegentoreFid.getText()));
            preparedStatement.setInt(8, Integer.parseInt(punkteFid.getText()));

        } catch (SQLException exception) {
            Logger.getLogger(AddTabelleController.class.getName()).log(Level.SEVERE, null, exception);
        }

    }

    private void getQuery() {
        if (aktualisieren == false) {

            query = "INSERT INTO tabelle (Verein, Spiele, Siege, Niederlagen, Unentschieden, Tore, Gegentore, Punkte) VALUES (?,?,?,?,?,?,?,?)";

        }else{
            query = "UPDATE tabelle SET "
                    + "`Verein`=?,"
                    + "`Spiele`=?,"
                    + "`Siege`=?,"
                    + "`Niederlagen`=?,"
                    + "`Unentschieden`=?,"
                    + "`Tore`=?,"
                    + "`Gegentore`=?,"
                    + "`Punkte`=?";

        }
    }
    void setTextField(String verein, String spiele, int siege, int niederlagen, int unentschieden, int tore, int gegentore, int punkte) {

        vereinFid.setText(verein);
        spieleFid.setText(spiele);
        siegeFid.setText(String.valueOf(siege));
        niederlagenFid.setText(String.valueOf(niederlagen));
        unentschiedenFid.setText(String.valueOf(unentschieden));
        toreFid.setText(String.valueOf(tore));
        gegentoreFid.setText(String.valueOf(gegentore));
        punkteFid.setText(String.valueOf(punkte));

    }

    void setUpdate(boolean b) {
        this.aktualisieren = b;

    }
}
