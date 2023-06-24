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

    public String getVerein() {
        return verein;
    }

    public void setVerein(String verein) {
        this.verein = verein;
    }

    public Integer getSpiele() {
        return spiele;
    }

    public void setSpiele(Integer spiele) {
        this.spiele = spiele;
    }

    public Integer getSiege() {
        return siege;
    }

    public void setSiege(Integer siege) {
        this.siege = siege;
    }

    public Integer getNiederlagen() {
        return niederlagen;
    }

    public void setNiederlagen(Integer niederlagen) {
        this.niederlagen = niederlagen;
    }

    public Integer getUnentschieden() {
        return unentschieden;
    }

    public void setUnentschieden(Integer unentschieden) {
        this.unentschieden = unentschieden;
    }

    public Integer getTore() {
        return tore;
    }

    public void setTore(Integer tore) {
        this.tore = tore;
    }

    public Integer getGegentore() {
        return gegentore;
    }

    public void setGegentore(Integer gegentore) {
        this.gegentore = gegentore;
    }

    public Integer getTordifferenz() {
        return tore-gegentore;
    }

    public Integer getPunkte() {
        return siege*3+unentschieden*1;
    }
}
