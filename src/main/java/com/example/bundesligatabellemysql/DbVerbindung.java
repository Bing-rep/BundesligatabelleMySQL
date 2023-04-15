package com.example.bundesligatabellemysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbVerbindung {
    private static String HOST = "localhost";
    private static int PORT = 3306;
    private static String DB_NAME = "bundesligatabelle";
    private static String Benutzername = "root";
    private static String PASSWORT = "";
    private static Connection verbindung ;


    public static Connection getConnect (){
        try {
            verbindung = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),Benutzername,PASSWORT);
        } catch (SQLException exception) {
            Logger.getLogger(DbVerbindung.class.getName()).log(Level.SEVERE, null, exception);
        }

        return verbindung;
    }
}