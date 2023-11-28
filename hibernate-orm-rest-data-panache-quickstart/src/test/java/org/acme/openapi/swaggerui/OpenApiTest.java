package org.acme.openapi.swaggerui;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class OpenApiTest {

    @Test
    public void testOpenApi() {
        given()
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body(containsString("openapi"));
    }

    @Test
    public void testOpenApiVersion() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("openapi", is(equalTo("3.0.3")));
    }

    @Test
    public void testOpenApiInfoVersion() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("info.version", is(equalTo("1.0.0-SNAPSHOT")));
    }

    @Test
    public void testOpenApiInfoVersion() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("info.version", is(equalTo("1.0.0-SNAPSHOT")));
    }
}
