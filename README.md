﻿# Bundeligatabelle MySQL
Dieses JavaFx Programm greift auf eine SQL Datenbankbank zu und ist in der Lage Werte hinzuzufügen, zu aktualisieren und zu löschen.
### Bilder
[![Tabelle](https://cdn.discordapp.com/attachments/518864192665550848/1124051199038074881/Screenshot_2023-06-29_205048.png "Tabelle")](http://https://cdn.discordapp.com/attachments/518864192665550848/1124051199038074881/Screenshot_2023-06-29_205048.png "Tabelle")

Die Werte werden aus der Datenbank ausgelesen.

[![Hinzufügen](https://cdn.discordapp.com/attachments/518864192665550848/1124051957494063114/Screenshot_2023-06-29_210040.png "Hinzufügen")](httphttps://cdn.discordapp.com/attachments/518864192665550848/1124051957494063114/Screenshot_2023-06-29_210040.png:// "Hinzufügen")

Werte können über dieses Fenster in die Datenbank ergänzt werden.

## Erklärung

### AddTabelleController
Dieser Code enthält Funktionen, um Daten aus den Textfeldern abzurufen, sie in einer Datenbank zu speichern und die Textfelder zurückzusetzen. Es gibt auch Methoden zum Erstellen der SQL-Abfrage basierend auf dem Aktualisierungsstatus und zum Setzen der Textfelder mit übergebenen Werten.

### Bundesliga
Diese Klasse stellt eine Datenstruktur dar, die Informationen über ein Bundesligateam enthält. Sie enthält Attribute für den Vereinsnamen, die Anzahl der Spiele, Siege, Niederlagen, Unentschieden, Tore und Gegentore. Zusätzlich gibt es Getter- und Setter-Methoden für jedes Attribut, um den Zugriff auf die Daten zu ermöglichen. Es gibt auch Methoden, um die Tordifferenz und die Gesamtpunktzahl des Teams zu berechnen.

### BundesligaController
Es handelt sich um einen JavaFX-Controller, der die Aktionen und die Datenbindung für die Bundesliga-Tabelle verwaltet. Hier sind die Hauptfunktionen und ihre Erklärungen:

- Die Klasse implementiert das Initializable-Interface und überschreibt die Methode initialize, die beim Initialisieren des Controllers aufgerufen wird.
- Die FXML-Elemente wie TableView und TableColumn werden mit den entsprechenden Annotationen (@FXML) markiert, um die Verbindung zur FXML-Datei herzustellen.
- Es werden Instanzvariablen für die Datenbankverbindung, die PreparedStatement, den ResultSet und das ObservableList definiert.
- Die Methode aktualisierTabelle ruft die Daten aus der Datenbank ab und aktualisiert die ObservableList mit den Bundesliga-Objekten.
- Die Methode loadDate initialisiert die Datenbindung zwischen den Spalten und den Bundesliga-Objekten und definiert eine benutzerdefinierte CellFactory für die Spalte eingabeSpalte, die eine Zelle mit Buttons erstellt.
- Die restlichen Methoden sind mit den entsprechenden FXML-Elementen verbunden und enthalten die Logik für die Aktionen (z.B. das Schließen des Fensters, das Drucken usw.).
- Bitte beachte, dass der Code einige Abhängigkeiten zu externen Bibliotheken enthält, z.B. zu FontAwesomeIcons. Stelle sicher, dass diese Bibliotheken in deinem Projekt verfügbar sind, damit der Code korrekt ausgeführt werden kann.

