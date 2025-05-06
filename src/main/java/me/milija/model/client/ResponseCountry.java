package me.milija.model.client;

public class ResponseCountry {

    private String countryCode;
    private String name;

    public ResponseCountry() {

    }

    public ResponseCountry(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AvailableCountries{" +
                "countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
