package me.milija.model;

import java.util.Objects;

public class Trener {
    private String ime;
    private String prezime;
    private String nacionalnost;

    public Trener(String ime, String prezime, String nacionalnost) {
        this.ime = ime;
        this.prezime = prezime;
        this.nacionalnost = nacionalnost;
    }

    public Trener() {

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trener trener = (Trener) o;
        return Objects.equals(getIme(), trener.getIme()) && Objects.equals(getPrezime(), trener.getPrezime()) && Objects.equals(getNacionalnost(), trener.getNacionalnost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIme(), getPrezime(), getNacionalnost());
    }
}
