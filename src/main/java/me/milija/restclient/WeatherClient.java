package me.milija.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import me.milija.model.client.ResponseWeather;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.ArrayList;


@Path("")
@RegisterRestClient(configKey = "weather-api")
public interface WeatherClient {

    @GET
    @Path("/weather/{city}")
    ResponseWeather getForecast(@PathParam("city") String city);

}
