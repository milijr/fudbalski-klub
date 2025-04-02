package me.milija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Trener {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trener_seq")
    private Long id;
    private String ime;
    private String prezime;
    private String nacionalnost;

    public Trener(Long id, String ime, String prezime, String nacionalnost) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Trener trener = (Trener) o;
        return getId().equals(trener.getId()) && getIme().equals(trener.getIme()) && getPrezime().equals(trener.getPrezime()) && getNacionalnost().equals(trener.getNacionalnost());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getIme().hashCode();
        result = 31 * result + getPrezime().hashCode();
        result = 31 * result + getNacionalnost().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", nacionalnost='" + nacionalnost + '\'' +
                '}';
    }
}
