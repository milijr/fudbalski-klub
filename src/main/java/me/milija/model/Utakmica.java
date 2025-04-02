package me.milija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Utakmica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utakmica_seq")
    private Long id;
    private String stadion;
    private Date datum;

    public Utakmica(Long id, String stadion, Date datum) {
        this.id = id;
        this.stadion = stadion;
        this.datum = datum;
    }

    public Utakmica() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Utakmica utakmica = (Utakmica) o;
        return Objects.equals(getId(), utakmica.getId()) && Objects.equals(getStadion(), utakmica.getStadion()) && Objects.equals(getDatum(), utakmica.getDatum());
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(getId());
        result = 31 * result + getStadion().hashCode();
        result = 31 * result + getDatum().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Utakmica{" +
                "id=" + id +
                ", stadion='" + stadion + '\'' +
                ", datum=" + datum +
                '}';
    }
}
