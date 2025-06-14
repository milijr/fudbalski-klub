package me.milija.model.client;

import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import java.io.InputStream;

public class RequestMultipart {

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream file;

    @RestForm("name")
    @PartType(MediaType.TEXT_PLAIN)
    private String name;

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
