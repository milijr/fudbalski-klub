package me.milija.model.client;

import me.milija.model.Forecast;
import me.milija.model.Weather;

import java.util.ArrayList;

public class ResponseWeather {
    private String city;
    private String temperature;
    private String wind;
    private String description;
    ArrayList<Forecast> forecast = new ArrayList<Forecast>();

    public ResponseWeather() {
    }

    public ResponseWeather(String city, String temperature, String wind, String description, ArrayList<Forecast> forecast) {
        this.city = city;
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

        public void setWind(String wind) {
            this.wind = wind;
        }

        public void setDescription( String description ) {
            this.description = description;
        }



}
