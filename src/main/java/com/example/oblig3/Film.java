package com.example.oblig3;

public class Film {
    private int id;
    private String filmNavn;
    private String fornavn;
    private String etternavn;
    private String tlfnr;
    private String epost;
    private int antall;

    public Film (int id, String filmNavn, String fornavn, String etternavn, String tlfnr, String epost, int antall) {
        this.id = id;
        this.filmNavn = filmNavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tlfnr = tlfnr;
        this.epost = epost;
        this.antall = antall;
    }

    public Film() { }

    public int getId() {
        return id;
    }

    public int getAntall() {
        return antall;
    }

    public String getEpost() {
        return epost;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getFilmNavn() {
        return filmNavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getTlfnr() {
        return tlfnr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setFilmNavn(String filmNavn) {
        this.filmNavn = filmNavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }
}
