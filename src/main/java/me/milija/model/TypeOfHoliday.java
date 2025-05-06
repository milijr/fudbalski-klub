package me.milija.model;

import jakarta.persistence.*;
import me.milija.restclient.HolidayClient;

@Entity
public class TypeOfHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hol_type_seq")
    private Long id;

    private String type;

    @ManyToOne
    private Holiday holiday;

    public TypeOfHoliday() {
    }

    public TypeOfHoliday(Long id, String type, Holiday holiday) {
        this.id = id;
        this.type = type;
        this.holiday = holiday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}
