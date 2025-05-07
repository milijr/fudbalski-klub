package me.milija.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.milija.model.Holiday;
import me.milija.model.Klub;
import me.milija.model.TypeOfHoliday;
import me.milija.model.client.ResponseCountry;
import me.milija.model.client.ResponseHoliday;
import me.milija.model.client.ResponseWeather;
import me.milija.model.client.UtakmicaIgrac;
import me.milija.repository.HolidayRepository;
import me.milija.repository.KlubRepository;
import me.milija.repository.WeatherRepository;
import me.milija.restclient.AvailableCountriesClient;
import me.milija.restclient.HolidayClient;
import me.milija.restclient.WeatherClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/klub/")
public class KlubResource {

    @Inject
    private KlubRepository kr;

    @Inject
    private HolidayRepository holr;

    @Inject
    private WeatherRepository weat;

    @RestClient
    private WeatherClient wc;

    @RestClient
    private AvailableCountriesClient av;

    @RestClient
    private HolidayClient hc;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/dodajKlub")
    public Response dodajKlub(Klub klub){
        Klub k = kr.dodajKlub(klub);
        return Response.ok().entity(k).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllClubs")
    public Response sviKlubovi(){
        List<Klub> klubovi = kr.allClubs();

        return Response.ok().entity(klubovi).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createUtakmicaIgrac")
    public Response getUI(UtakmicaIgrac ui){

        UtakmicaIgrac u = kr.createUtakmicaIgrac(ui);

        return Response.ok().entity(u).build();

    }

    @GET
    @Path("getAvailableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCountries() {
        List<ResponseCountry> ac = av.getAvailableCountries();
        return Response.ok().entity(ac).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/NextPublicHolidays/{countryCode}")
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode){
        List<ResponseHoliday> holResp = hc.getNextPublicHolidays(countryCode);


        for (ResponseHoliday hr : holResp) {
            Holiday h = convertToHolidayEntity(hr);
            if (!holr.existsByDateAndCountryCode(h.getDate(), h.getCountryCode())) {
                holr.createHoliday(h);
            }
        }

        return Response.ok().entity(holResp).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getForecast/")
    public Response getForecast(@QueryParam("city") String city){

        ResponseWeather weatResp = wc.getForecast(city);

        return Response.ok().entity(weatResp).build();

    }

    private Holiday convertToHolidayEntity(ResponseHoliday hr) {
        Holiday holiday = new Holiday();
        holiday.setDate(hr.getDate());
        holiday.setLocalName(hr.getLocalName());
        holiday.setName(hr.getName());
        holiday.setCountryCode(hr.getCountryCode());
        holiday.setGlobal(hr.isGlobal());
        holiday.setLaunchYear(hr.getLaunchYear());

        List<TypeOfHoliday> types = hr.getTypes().stream()
                .map(type -> {
                    TypeOfHoliday holidayType = new TypeOfHoliday();
                    holidayType.setType(type);
                    holidayType.setHoliday(holiday);
                    return holidayType;
                })
                .collect(Collectors.toList());

        holiday.setTypes(types);
        return holiday;
    }


}
