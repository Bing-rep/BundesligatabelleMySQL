package com.example.bundesligatabellemysql;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TabellenBedienung extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("com/example/bundesligatabellemysql/Bundesligatabelle.fxml")));
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.show();
        } catch (IOException exception) {
            Logger.getLogger(TabellenBedienung.class.getName()).log(Level.SEVERE, null, exception);
        }


    }

    public static void main(String[] args) {
        launch((args));
    }

}

