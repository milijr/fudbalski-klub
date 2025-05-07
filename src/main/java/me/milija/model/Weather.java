package me.milija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_seq")
    private Long id;
    private String city;
    private String temperature;
    private String wind;
    private String description;
    ArrayList<Forecast> forecast = new ArrayList<Forecast>();

    public Weather() {
    }

    public Weather(String city, Long id, String temperature, String wind, String description, ArrayList<Forecast> forecast) {
        this.city = city;
        this.id = id;
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind() {
        return wind;
    }

    public String getDescription() {
        return description;
    }


    public void setTemperature( String temperature ) {
        this.temperature = temperature;
    }

    public void setWind( String wind ) {
        this.wind = wind;
    }

    public void setDescription( String description ) {
        this.description = description;
    }



}
