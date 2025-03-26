package me.milija.model;

import java.util.Objects;

public class Igrac {

    private String ime;
    private String prezime;
    private String pozicija;
    private int broj_dresa;

    public Igrac(String ime, String prezime, String pozicija, int broj_dresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.broj_dresa = broj_dresa;
    }

    public Igrac() {

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

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public int getBroj_dresa() {
        return broj_dresa;
    }

    public void setBroj_dresa(int broj_dresa) {
        this.broj_dresa = broj_dresa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Igrac igrac = (Igrac) o;
        return getBroj_dresa() == igrac.getBroj_dresa() && Objects.equals(getIme(), igrac.getIme()) && Objects.equals(getPrezime(), igrac.getPrezime()) && Objects.equals(getPozicija(), igrac.getPozicija());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIme(), getPrezime(), getPozicija(), getBroj_dresa());
    }
}
