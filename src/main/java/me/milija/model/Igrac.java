package me.milija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Igrac {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "igrac_seq")
    private Long id;
    private String ime;
    private String prezime;
    private String pozicija;
    private int broj_dresa;

    public Igrac(Long id, String ime, String prezime, String pozicija, int broj_dresa) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.broj_dresa = broj_dresa;
    }

    public Igrac() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return getBroj_dresa() == igrac.getBroj_dresa() && getId().equals(igrac.getId()) && getIme().equals(igrac.getIme()) && getPrezime().equals(igrac.getPrezime()) && getPozicija().equals(igrac.getPozicija());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getIme().hashCode();
        result = 31 * result + getPrezime().hashCode();
        result = 31 * result + getPozicija().hashCode();
        result = 31 * result + getBroj_dresa();
        return result;
    }

    @Override
    public String toString() {
        return "Igrac{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pozicija='" + pozicija + '\'' +
                ", broj_dresa=" + broj_dresa +
                '}';
    }
}
