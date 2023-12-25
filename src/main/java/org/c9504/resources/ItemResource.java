package org.c9504.resources;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.c9504.entities.Item;
import org.c9504.interfaces.ItemMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/items")
public class ItemResource implements ItemMethods  {

    @Inject
    Template items;

    @Inject
    Template addItem;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Item", "Test description"));
        items.add(new Item("Test Item 2", "Test description 2"));
        Map<String, Object> data = new HashMap<>();
        data.put("items", items);
        return this.items.data(data);
    }

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @Override
    public TemplateInstance create() {
        return addItem.instance().data("created", false);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Override
    public TemplateInstance add(@FormParam("name") String name, @FormParam("description") String description) {
        Item item = new Item(name, description);
        Map<String, Object> data = new HashMap<>();
        data.put("item", item);
        data.put("created", true);
        return addItem.data(data);
    }

    @Override
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance delete(Item item) {
        return null;
    }

    @Override
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance update(Item item) {
        return null;
    }

}
