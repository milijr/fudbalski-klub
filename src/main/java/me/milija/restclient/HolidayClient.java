package me.milija.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.milija.model.client.ResponseHoliday;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("")
@RegisterRestClient(configKey = "country-api")
public interface HolidayClient {

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<ResponseHoliday> getNextPublicHolidays(@PathParam("countryCode") String countryCode);

}
