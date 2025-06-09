package me.milija.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forecast_seq")
    private Long id;

    private String city;
    private String day;
    private String temperature;
    private String wind;

    public Forecast() {
    }

    public Forecast(Long id, String city, String day, String temperature, String wind) {
        this.id = id;
        this.city = city;
        this.day = day;
        this.temperature = temperature;
        this.wind = wind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
