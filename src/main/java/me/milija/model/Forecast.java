package me.milija.model;

public class Forecast {
    private String day;
    private String temperature;
    private String wind;

    public Forecast() {
    }

    public Forecast(String day, String temperature, String wind) {
        this.day = day;
        this.temperature = temperature;
        this.wind = wind;
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
