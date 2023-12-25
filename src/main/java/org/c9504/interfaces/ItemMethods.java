package org.c9504.interfaces;

import io.quarkus.qute.TemplateInstance;
import org.c9504.entities.Item;

public interface ItemMethods {


    TemplateInstance getAll();
    TemplateInstance create();
    TemplateInstance add(String name, String description);
    TemplateInstance delete(Item item);
    TemplateInstance update(Item item);

}
