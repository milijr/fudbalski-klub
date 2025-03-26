package me.milija.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Klub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klub_seq")
    private long id;
    private String grad;
    private String godina;
    private String naziv;

    public Klub(long id, String godina, String grad, String naziv) {
        this.id = id;
        this.godina = godina;
        this.grad = grad;
        this.naziv = naziv;
    }

    public Klub() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Klub klub = (Klub) o;
        return getId() == klub.getId() && getGodina() == klub.getGodina() && Objects.equals(getGrad(), klub.getGrad()) && Objects.equals(getNaziv(), klub.getNaziv());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGrad(), getGodina(), getNaziv());
    }
}
