package me.milija.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Klub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klub_seq")
    private Long id;
    private String grad;
    private String godina;
    private String naziv;

    public Klub(Long id, String godina, String grad, String naziv) {
        this.id = id;
        this.godina = godina;
        this.grad = grad;
        this.naziv = naziv;
    }

    public Klub() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public final boolean equals(Object o) {
        if (!(o instanceof Klub klub)) return false;
        return getId().equals(klub.getId()) && getGrad().equals(klub.getGrad()) && getGodina().equals(klub.getGodina()) && getNaziv().equals(klub.getNaziv());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getGrad().hashCode();
        result = 31 * result + getGodina().hashCode();
        result = 31 * result + getNaziv().hashCode();
        return result;
    }
}
