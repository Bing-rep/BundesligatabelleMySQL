package com.example.bundesligatabellemysql;

public class Bundesliga {

    String verein;
    int spiele;
    int siege;
    int niederlagen;
    int unentschieden;
    int tore;
    int gegentore;

    public Bundesliga(String verein, int spiele, int siege, int niederlagen, int unentschieden, int tore, int gegentore) {
        this.verein = verein;
        this.spiele = spiele;
        this.siege = siege;
        this.niederlagen = niederlagen;
        this.unentschieden = unentschieden;
        this.tore = tore;
        this.gegentore = gegentore;
    }
    // Konstruktor der Bundesliga-Klasse, der alle Eigenschaften eines Teams initialisiert

    public String getVerein() {
        return verein;
    }

    public void setVerein(String verein) {
        this.verein = verein;
    }
    // Getter und Setter für das Vereinsattribut

    public Integer getSpiele() {
        return spiele;
    }

    public void setSpiele(Integer spiele) {
        this.spiele = spiele;
    }
    // Getter und Setter für das Spieleattribut

    public Integer getSiege() {
        return siege;
    }

    public void setSiege(Integer siege) {
        this.siege = siege;
    }
    // Getter und Setter für das Siegeattribut

    public Integer getNiederlagen() {
        return niederlagen;
    }

    public void setNiederlagen(Integer niederlagen) {
        this.niederlagen = niederlagen;
    }
    // Getter und Setter für das Niederlagenattribut

    public Integer getUnentschieden() {
        return unentschieden;
    }

    public void setUnentschieden(Integer unentschieden) {
        this.unentschieden = unentschieden;
    }
    // Getter und Setter für das Unentschiedenattribut

    public Integer getTore() {
        return tore;
    }

    public void setTore(Integer tore) {
        this.tore = tore;
    }
    // Getter und Setter für das Toreattribut

    public Integer getGegentore() {
        return gegentore;
    }

    public void setGegentore(Integer gegentore) {
        this.gegentore = gegentore;
    }
    // Getter und Setter für das Gegentoreattribut

    public Integer getTordifferenz() {
        return tore - gegentore;
    }
    // Methode zur Berechnung der Tordifferenz (Tore - Gegentore)

    public Integer getPunkte() {
        return siege * 3 + unentschieden;
    }
    // Methode zur Berechnung der Gesamtpunktzahl (Siege * 3 + Unentschieden)
}
/*
Diese Klasse stellt eine Datenstruktur dar, die Informationen über ein Bundesligateam enthält. Sie enthält Attribute für
den Vereinsnamen, die Anzahl der Spiele, Siege, Niederlagen, Unentschieden, Tore und Gegentore. Zusätzlich gibt es Getter-
und Setter-Methoden für jedes Attribut, um den Zugriff auf die Daten zu ermöglichen. Es gibt auch Methoden,
um die Tordifferenz und die Gesamtpunktzahl des Teams zu berechnen.
 */