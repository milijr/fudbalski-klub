package me.milija.model;

import java.sql.Date;
import java.util.Objects;

public class Utakmica {

    private String stadion;
    private Date datum;

    public Utakmica(String stadion, Date datum) {
        this.stadion = stadion;
        this.datum = datum;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Utakmica utakmica = (Utakmica) o;
        return Objects.equals(getStadion(), utakmica.getStadion()) && Objects.equals(getDatum(), utakmica.getDatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStadion(), getDatum());
    }
}
