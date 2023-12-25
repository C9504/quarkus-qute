package org.c9504.resources;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class WelcomeResource {

    @Inject
    Template index;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance welcome() {
        return index.instance();
    }

}
