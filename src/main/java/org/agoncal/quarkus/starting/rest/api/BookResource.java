package org.agoncal.quarkus.starting.rest.api;

import org.agoncal.quarkus.starting.entity.BookEntity;
import org.agoncal.quarkus.starting.repository.BookRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<BookEntity> getAllBook() {
        return bookRepository.getAllBook();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return getAllBook().size();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Optional<BookEntity> getBook(@PathParam("id") int id) {
        return bookRepository.getBook(id);
    }

}
