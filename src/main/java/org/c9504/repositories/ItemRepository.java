package org.c9504.repositories;

import java.util.UUID;

import org.c9504.entities.Item;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepositoryBase<Item, UUID> {
    
}
