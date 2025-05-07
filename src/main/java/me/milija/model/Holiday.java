package me.milija.model;

import jakarta.persistence.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Holiday.GET_HOLIDAY_BY_DATE_AND_COUNTRY_CODE, query = "Select COUNT(h) from Holiday h WHERE h.date = :date and h.countryCode = :countryCode")
public class Holiday {
    public static final String GET_HOLIDAY_BY_DATE_AND_COUNTRY_CODE = "Holiday.getHolidayByDateAndCountry";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_seq")
    private Long id;

    private LocalDate date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean global;
    private List<String> counties;
    private int launchYear;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "holiday_id")
    private List<TypeOfHoliday> types;

    public Holiday() {
    }

    public Holiday(Long id, LocalDate date, String localName, String name, String countryCode, boolean global, List<String> counties, int launchYear, List<TypeOfHoliday> types) {
        this.id = id;
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.types = types;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public List<String> getCounties() {
        return counties;
    }

    public void setCounties(List<String> counties) {
        this.counties = counties;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public List<TypeOfHoliday> getTypes() {
        return types;
    }

    public void setTypes(List<TypeOfHoliday> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Holiday holiday = (Holiday) o;
        return isGlobal() == holiday.isGlobal() && getLaunchYear() == holiday.getLaunchYear() && Objects.equals(id, holiday.id) && Objects.equals(getDate(), holiday.getDate()) && Objects.equals(getLocalName(), holiday.getLocalName()) && Objects.equals(getName(), holiday.getName()) && Objects.equals(getCountryCode(), holiday.getCountryCode()) && Objects.equals(getCounties(), holiday.getCounties()) && Objects.equals(getTypes(), holiday.getTypes());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(getDate());
        result = 31 * result + Objects.hashCode(getLocalName());
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getCountryCode());
        result = 31 * result + Boolean.hashCode(isGlobal());
        result = 31 * result + Objects.hashCode(getCounties());
        result = 31 * result + getLaunchYear();
        result = 31 * result + Objects.hashCode(getTypes());
        return result;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", global=" + global +
                ", counties=" + counties +
                ", launchYear=" + launchYear +
                ", types=" + types +
                '}';
    }
}
