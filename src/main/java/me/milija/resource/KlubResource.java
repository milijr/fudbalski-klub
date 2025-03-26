package me.milija.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.milija.model.Klub;
import me.milija.repository.KlubRepository;

@Path("/klub/")
public class KlubResource {

    @Inject
    private KlubRepository kr;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/dodajKlub")
    public Response dodajKlub(Klub klub){
        Klub k = kr.dodajKlub(klub);
        return Response.ok().entity(k).build();
    }


}
