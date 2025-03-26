package me.milija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Utakmica {

    @Id
    private long id;
    private String stadion;
    private Date datum;

    public Utakmica(long id, String stadion, Date datum) {
        this.id = id;
        this.stadion = stadion;
        this.datum = datum;
    }

    public Utakmica() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Utakmica utakmica)) return false;

        return getId() == utakmica.getId() && getStadion().equals(utakmica.getStadion()) && getDatum().equals(utakmica.getDatum());
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(getId());
        result = 31 * result + getStadion().hashCode();
        result = 31 * result + getDatum().hashCode();
        return result;
    }
}
