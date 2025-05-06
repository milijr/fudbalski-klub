package me.milija.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.milija.model.client.ResponseCountry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("")
@RegisterRestClient(configKey = "country-api")
public interface AvailableCountriesClient {

    @GET
    @Path("/AvailableCountries")
    List<ResponseCountry> getAvailableCountries();

}
