package com.example.bundesligatabellemysql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BundesligatabelleController implements Initializable {

    @FXML
    private TableView<Bundesliga> bundesligaTabelle;
    @FXML
    private TableColumn<Bundesliga, String> eingabeSpalte;

    @FXML
    private TableColumn<Bundesliga, String> niederlagenSpalte;

    @FXML
    private TableColumn<Bundesliga, String> punkteSpalte;

    @FXML
    private TableColumn<Bundesliga, String> siegeSpalte;

    @FXML
    private TableColumn<Bundesliga, String> spieleSpalte;

    @FXML
    private TableColumn<Bundesliga, String> tordifferenzSpalte;

    @FXML
    private TableColumn<Bundesliga, String> toreSpalte;
    @FXML
    private TableColumn<Bundesliga, String> gegentoreSpalte;

    @FXML
    private TableColumn<Bundesliga, String>unentschiedenSpalte;

    @FXML
    private TableColumn<Bundesliga, String> vereinSpalte;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Bundesliga bundesliga = null;

    ObservableList<Bundesliga> BundesligaListe = FXCollections.observableArrayList();

    @FXML
    void aktualisierTabelle() {
        try {
            BundesligaListe.clear();

            query = "SELECT * FROM `tabelle`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                BundesligaListe.add(new Bundesliga(
                        resultSet.getString("Verein"),
                        resultSet.getInt("Spiele"),
                        resultSet.getInt("Siege"),
                        resultSet.getInt("Niederlagen"),
                        resultSet.getInt("Unentschieden"),
                        resultSet.getInt("Tore"),
                        resultSet.getInt("Gegentore"),
                        resultSet.getInt("Tordifferenz"),
                        resultSet.getInt("Punkte")));
                bundesligaTabelle.setItems(BundesligaListe);
            }


        } catch (SQLException exception){
            Logger.getLogger(BundesligatabelleController.class.getName()).log(Level.SEVERE,null,exception);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        loadDate();
    }

    @FXML
    void beenden(MouseEvent event) {

    }

    @FXML
    void drucken(MouseEvent event) {

    }

    @FXML
    void getHinzufügenAnsicht(MouseEvent event) {

    }

    private void loadDate() {

        connection = DbVerbindung.getConnect();
        aktualisierTabelle();


        vereinSpalte.setCellValueFactory(new PropertyValueFactory<>("verein"));
        spieleSpalte.setCellValueFactory(new PropertyValueFactory<>("spiele"));
        siegeSpalte.setCellValueFactory(new PropertyValueFactory<>("siege"));
        niederlagenSpalte.setCellValueFactory(new PropertyValueFactory<>("niederlagen"));
        unentschiedenSpalte.setCellValueFactory(new PropertyValueFactory<>("unentschieden"));
        toreSpalte.setCellValueFactory(new PropertyValueFactory<>("tore"));
        gegentoreSpalte.setCellValueFactory(new PropertyValueFactory<>("gegentore"));
        tordifferenzSpalte.setCellValueFactory(new PropertyValueFactory<>("tordifferenz"));
        punkteSpalte.setCellValueFactory(new PropertyValueFactory<>("punkte"));
        eingabeSpalte.setCellValueFactory(new PropertyValueFactory<>("eingabe"));
    }
}
