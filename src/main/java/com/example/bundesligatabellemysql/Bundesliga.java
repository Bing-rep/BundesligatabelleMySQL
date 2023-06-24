package com.example.bundesligatabellemysql;

public class Bundesliga {

    String verein;
    String spiele;
    String siege;
    String niederlagen;
    String unentschieden;
    String tore;
    String gegentore;
    String tordifferenz;
    String punkte;


    public Bundesliga(String verein, String spiele, String siege, String niederlagen, String unentschieden, String tore, String gegentore, String tordifferenz, String punkte) {
        this.verein = verein;
        this.spiele = spiele;
        this.siege = siege;
        this.niederlagen = niederlagen;
        this.unentschieden = unentschieden;
        this.tore = tore;
        this.gegentore = gegentore;
        this.tordifferenz = tordifferenz;
        this.punkte = punkte;
    }

    public String getVerein() {
        return verein;
    }

    public void setVerein(String verein) {
        this.verein = verein;
    }

    public String getSpiele() {
        return spiele;
    }

    public void setSpiele(String spiele) {
        this.spiele = spiele;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getNiederlagen() {
        return niederlagen;
    }

    public void setNiederlagen(String niederlagen) {
        this.niederlagen = niederlagen;
    }

    public String getUnentschieden() {
        return unentschieden;
    }

    public void setUnentschieden(String unentschieden) {
        this.unentschieden = unentschieden;
    }

    public String getTore() {
        return tore;
    }

    public void setTore(String tore) {
        this.tore = tore;
    }

    public String getGegentore() {
        return gegentore;
    }

    public void setGegentore(String gegentore) {
        this.gegentore = gegentore;
    }

    public String getTordifferenz() {
        return tordifferenz;
    }

    public void setTordifferenz(String tordifferenz) {
        this.tordifferenz = tordifferenz;
    }

    public String getPunkte() {
        return punkte;
    }

    public void setPunkte(String punkte) {
        this.punkte = punkte;
    }
}
