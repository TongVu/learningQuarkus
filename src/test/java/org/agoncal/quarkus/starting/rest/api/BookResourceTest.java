package org.agoncal.quarkus.starting.rest.api;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.starting.repository.BookRepository;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BookResourceTest {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @Test
    void getAllBook() {
        given().header(ACCEPT, TEXT_PLAIN)
                .when().get("/api/books")
                .then()
                .statusCode(OK.getStatusCode())
                .body(is(bookRepository.getAllBook().toString()));
    }

    @Test
    void countAllBooks() {
        when().get("/api/books/count")
                .then()
                .statusCode(OK.getStatusCode())
                .body(is("4"));
    }

    @Test
    void getBook() {
        logger.info("===================================\n" +
                bookRepository.getBook(1).toString());
        given()
                .header(ACCEPT, TEXT_PLAIN)
                .pathParams("id", 1).
                when()
                .get("/api/books/{id}").
                then()
                .statusCode(OK.getStatusCode())
                .body(is(bookRepository.getBook(1).toString()));

    }
}