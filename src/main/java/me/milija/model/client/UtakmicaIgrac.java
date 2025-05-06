package me.milija.model.client;

import jakarta.persistence.*;
import me.milija.model.Igrac;
import me.milija.model.Utakmica;

import java.util.Objects;

@Entity
public class UtakmicaIgrac {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utakmicaigrac_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    Utakmica utakmica;

    @ManyToOne(cascade = CascadeType.ALL)
    Igrac igrac;

    public UtakmicaIgrac() {
        super();
    }

    public UtakmicaIgrac(Utakmica utakmica, Igrac igrac) {
        this.utakmica = utakmica;
        this.igrac = igrac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UtakmicaIgrac that = (UtakmicaIgrac) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUtakmica(), that.getUtakmica()) && Objects.equals(getIgrac(), that.getIgrac());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getUtakmica());
        result = 31 * result + Objects.hashCode(getIgrac());
        return result;
    }

    @Override
    public String toString() {
        return "UtakmicaIgrac{" +
                "id=" + id +
                ", utakmica=" + utakmica +
                ", igrac=" + igrac +
                '}';
    }
}
