package org.c9504.resources;

import io.quarkus.qute.Template;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.c9504.entities.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ItemResourceTest {

    @Inject
    Template items, addItem;

    /*@Test
    public void testGetAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Item", "Test description"));
        items.add(new Item("Test Item 2", "Test description 2"));
        Map<String, Object> data = new HashMap<>();
        data.put("items", items);
        given().when()
                .get("/items")
                .then()
                .statusCode(200)
                .body(is(this.items.data(data).render()));
    }*/

    // @Test
    // public void testCreate() {
    //     Map<String, Object> data = new HashMap<>();
    //     data.put("created", false);
    //     given().when()
    //             .get("/items/create")
    //             .then()
    //             .statusCode(200)
    //             .body(is(addItem.render(data)));
    // }

    // @Test
    // public void testAdd() {
    //     Map<String, Object> data = new HashMap<>();
    //     data.put("item", new Item("Test Item", "Test description"));
    //     data.put("created", true);
    //     given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
    //             .when()
    //             .formParam("name", "Test Item")
    //             .formParam("description", "Test description")
    //             .post("/items/create")
    //             .then()
    //             .statusCode(200)
    //             .body(is(addItem.data(data).render()));
    // }
}
