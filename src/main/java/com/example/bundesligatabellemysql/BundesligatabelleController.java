package com.example.bundesligatabellemysql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.input.MouseEvent;


//import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

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
                        resultSet.getString("Spiele"),
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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void drucken(MouseEvent event) {

    }

    @FXML
    void getHinzufügenAnsicht(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addTabelle.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException exception) {
            Logger.getLogger(BundesligatabelleController.class.getName()).log(Level.SEVERE, null, exception);
        }
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

        Callback<TableColumn<Bundesliga, String>,TableCell<Bundesliga, String>> cellFactory = (TableColumn<Bundesliga, String> param) -> {
            // erstellt zeilen mit buttons
            final TableCell<Bundesliga, String> cell = new TableCell<Bundesliga, String>() {
                @Override
                public  void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //nicht leere Zeilen
                    if(empty) {
                        setGraphic(null);
                        setText(null);
                    }else {
                        FontAwesomeIconView löschenIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView bearbeitenIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        löschenIcon.setStyle(
                            " -fx-cursor: hand ;"
                            + "-glyph-size:28px;"
                            + "-fx-fill:#ff1744;"
                        );
                        bearbeitenIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"

                        );
                        löschenIcon.setOnMouseClicked((MouseEvent event) -> {
                            try {
                                bundesliga = bundesligaTabelle.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM tabelle WHERE Verein = "+bundesliga.getVerein();
                                connection = DbVerbindung.getConnect();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                aktualisierTabelle();
                            } catch (SQLException exception) {
                                Logger.getLogger(BundesligatabelleController.class.getName()).log(Level.SEVERE, null, exception);
                            }
                        });
                        bearbeitenIcon.setOnMouseClicked((MouseEvent event) -> {
                            bundesliga = bundesligaTabelle.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation((getClass().getResource("addTabelle.fxml")));
                            try {
                                loader.load();
                            } catch (IOException exception) {
                                Logger.getLogger(BundesligatabelleController.class.getName()).log(Level.SEVERE,null,exception);
                            }

                            AddTabelleController addTabelleController = loader.getController();
                            addTabelleController.setUpdate(true);
                            addTabelleController.setTextField(bundesliga.getVerein(), bundesliga.getSpiele(), bundesliga.getSiege(), bundesliga.getNiederlagen(),bundesliga.getUnentschieden(),bundesliga.getTore(),bundesliga.getGegentore(),bundesliga.getPunkte());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                        });

                        HBox managebtn = new HBox(bearbeitenIcon, löschenIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(löschenIcon, new Insets(2,2,0,3));
                        HBox.setMargin(bearbeitenIcon, new Insets(2,3,0,2));

                        setGraphic(managebtn);
                        setText(null);


                    }
                }
            };

            return  cell;
        };
        eingabeSpalte.setCellFactory(cellFactory);
        bundesligaTabelle.setItems(BundesligaListe);

    }
}
