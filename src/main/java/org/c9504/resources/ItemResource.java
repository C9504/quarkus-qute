package org.c9504.resources;

import io.quarkus.panache.common.Sort;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.c9504.entities.Item;
import org.c9504.interfaces.ItemMethods;
import org.c9504.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/items")
public class ItemResource implements ItemMethods  {

    private List<Item> itemsList;

    @Inject
    ItemRepository itemRepository;

    @Inject
    Template items;

    @Inject
    Template addItem;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Blocking
    public TemplateInstance getAll() {
        itemsList = itemRepository.findAll(Sort.by("name")).list();
        // items.add(new Item("Test Item", "Test description"));
        // items.add(new Item("Test Item 2", "Test description 2"));
        Map<String, Object> data = new HashMap<>();
        data.put("items", itemsList);
        return this.items.data(data);
    }

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @Blocking
    @Override
    public TemplateInstance create() {
        itemsList = itemRepository.findAll(Sort.by("name")).list();
        Map<String, Object> data = new HashMap<>();
        data.put("items", itemsList);
        data.put("created", false);
        return this.addItem.instance().data(data);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Transactional
    @Override
    public TemplateInstance add(@FormParam("name") String name, @FormParam("description") String description) {
        Item item = new Item(name, description);
        itemsList = new ArrayList<>();
        itemsList = itemRepository.findAll(Sort.by("name")).list();        
        Map<String, Object> data = new HashMap<>();
        data.put("item", item);
        data.put("items", itemsList);
        data.put("created", true);
        itemRepository.persist(item);
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
