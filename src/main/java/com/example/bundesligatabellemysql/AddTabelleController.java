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


public class AddTabelleController implements Initializable {


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

        if (Verein.isEmpty() || Spiele.isEmpty() || Siege.isEmpty()|| Niederlagen.isEmpty()|| Unentschieden.isEmpty()|| Tore.isEmpty()|| Gegentore.isEmpty())
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

    }
    private void insert() {

        try {
            preparedStatement = connection.prepareStatement((query));
            preparedStatement.setString(1,vereinFid.getText());
            preparedStatement.setString(2,spieleFid.getText());
            preparedStatement.setString(3,siegeFid.getText());
            preparedStatement.setString(4,niederlagenFid.getText());
            preparedStatement.setString(5,unentschiedenFid.getText());
            preparedStatement.setString(6,toreFid.getText());
            preparedStatement.setString(7,gegentoreFid.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            Logger.getLogger(AddTabelleController.class.getName()).log(Level.SEVERE, null, exception);
        }

    }

    private void getQuery() {
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
                    + "`Gegentore`=?";
        }
    }

    void setTextField(String verein, int spiele, int siege, int niederlagen, int unentschieden, int tore, int gegentore) {

        vereinFid.setText(verein);
        spieleFid.setText(String.valueOf(spiele));
        siegeFid.setText(String.valueOf(siege));
        niederlagenFid.setText(String.valueOf(niederlagen));
        unentschiedenFid.setText(String.valueOf(unentschieden));
        toreFid.setText(String.valueOf(tore));
        gegentoreFid.setText(String.valueOf(gegentore));

    }

    void setUpdate(boolean b) {
        this.aktualisieren = b;

    }
}
