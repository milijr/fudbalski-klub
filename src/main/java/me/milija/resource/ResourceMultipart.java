package me.milija.resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.milija.model.MultipartEntity;
import me.milija.model.client.RequestMultipart;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Path("/MultipartExample")
public class ResourceMultipart {

    @Inject
    EntityManager em;

    @Transactional
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@RestForm("file") FileUpload file,
                               @RestForm("name") String name,
                               @QueryParam("id") Long id) {

        MultipartEntity entity = em.find(MultipartEntity.class, id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Entity with ID " + id + " not found")
                    .build();
        }


        try {
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = uploadDir + file.fileName();
            File targetFile = new File(filePath);
            Files.move(file.uploadedFile(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            entity.setFilePath(filePath);

            em.merge(entity);

            return Response.ok("Fajl uspješno sačuvan.").build();
        } catch (Exception e) {
            return Response.serverError().entity("Greška pri snimanju fajla.").build();
        }

    }

    @Transactional
    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response fileUpload(RequestMultipart mp, @QueryParam("id") Long id) {
        if (mp.getFile() == null || mp.getName() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Fajl ili ime je null").build();
        }

        try {
            String folderPath = "uploads/";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }


            try (InputStream input = mp.getFile()) {
                Files.copy(input, Paths.get(folderPath + mp.getName()), StandardCopyOption.REPLACE_EXISTING);
            }

            MultipartEntity entity;

            if (id != null) {
                entity = em.find(MultipartEntity.class, id);
                if (entity == null) {
                    return Response.status(Response.Status.NOT_FOUND)
                            .entity("Entity sa ID " + id + " nije pronađen").build();
                }
            } else {
                entity = new MultipartEntity();
                em.persist(entity);
            }

            entity.setFilePath(folderPath + mp.getName());

            return Response.ok("Fajl uspešno snimljen i podaci sačuvani!").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Greška pri snimanju fajla i podataka u bazu").build();
        }
    }

    @POST
    @Path("/Upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(RequestMultipart mp) {
        if (mp.getFile() == null || mp.getName() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Fajl ili ime je null").build();
        }

        try {
            String folderPath = "uploads/";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            try (InputStream input = mp.getFile()) {
                Files.copy(input, Paths.get(folderPath + mp.getName()), StandardCopyOption.REPLACE_EXISTING);
            }

            return Response.ok("Fajl uspešno snimljen!").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Greška pri snimanju fajla").build();
        }
    }

    @GET
    @Path("/getWithFile")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getEntityWithFile(@QueryParam("id") Long id) {
        MultipartEntity entity = em.find(MultipartEntity.class, id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        File file = new File(entity.getFilePath());
        if (!file.exists()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Fajl ne postoji.").build();
        }

        try {
            return Response.ok(file)
                    .header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"")
                    .build();
        } catch (Exception e) {
            return Response.serverError().entity("Greška pri slanju fajla.").build();
        }
    }



}
