package com.example.bundesligatabellemysql;

public class Bundesliga {

    String verein;
    int spiele;
    int siege;
    int niederlagen;
    int unentschieden;
    int tore;
    int gegentore;
    int tordifferenz;
    int punkte;


    public Bundesliga(String verein, int spiele, int siege, int niederlagen, int unentschieden, int tore, int gegentore, int tordifferenz, int punkte) {
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

    public int getSpiele() {
        return spiele;
    }

    public void setSpiele(int spiele) {
        this.spiele = spiele;
    }

    public int getSiege() {
        return siege;
    }

    public void setSiege(int siege) {
        this.siege = siege;
    }

    public int getNiederlagen() {
        return niederlagen;
    }

    public void setNiederlagen(int niederlagen) {
        this.niederlagen = niederlagen;
    }

    public int getUnentschieden() {
        return unentschieden;
    }

    public void setUnentschieden(int unentschieden) {
        this.unentschieden = unentschieden;
    }

    public int getTore() {
        return tore;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }

    public int getGegentore() {
        return gegentore;
    }

    public void setGegentore(int gegentore) {
        this.gegentore = gegentore;
    }

    public int getTordifferenz() {
        return tordifferenz;
    }

    public void setTordifferenz(int tordifferenz) {
        this.tordifferenz = tordifferenz;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
