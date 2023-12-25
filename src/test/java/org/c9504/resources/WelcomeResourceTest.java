package org.c9504.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WelcomeResourceTest {

    @TestHTTPEndpoint(WelcomeResource.class)
    @TestHTTPResource
    URL url;

    @Test
    public void testWelcome() {
        given().when()
                .get("/welcome")
                .then()
                .statusCode(200)
                .body(is("Hello, Welcome to Quarkus Test Example"));
    }

    @Test
    public void testHttpWelcome() throws IOException {
        try (InputStream is = url.openStream()) {
            String contents = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("Hello, Welcome to Quarkus Test Example", contents);
        }
    }

}
