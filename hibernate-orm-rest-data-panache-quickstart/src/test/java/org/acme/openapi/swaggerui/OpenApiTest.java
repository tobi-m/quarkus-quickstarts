package org.acme.openapi.swaggerui;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class OpenApiTest {

    @Test
    public void testOpenApiVersion() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("openapi", is(equalTo("3.0.3")));
    }

    @Test
    public void testOpenApiQueryParameterNameIndex() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("paths./my-people/all.get.parameters[1].name", is(equalTo("name")));
    }

    @Test
    public void testOpenApiQueryParameterName() {
        given().accept(ContentType.JSON)
                .when().get("/q/openapi")
                .then()
                .statusCode(200)
                .body("paths./my-people/all.get.parameters[*].name", hasItems("name", "birthDate"));
    }
}
//https://jsonpath.com/
