package org.agoncal.quarkus.starting.repository;

import org.agoncal.quarkus.starting.entity.BookEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<BookEntity> getAllBook() {
        return List.of(
                new BookEntity(1, "English Grammar in use", "Ed Murphy", 2018, genre),
                new BookEntity(2, "Understanding Quarkus", "Antonio", 2020, genre),
                new BookEntity(3, "Practicing", "Aotonio", 2013, genre),
                new BookEntity(4, "Thinking in Java", "Bruce Eckel", 2018, genre)
        );
    }

    public Optional<BookEntity> getBook(int id){
        return getAllBook().stream()
                .filter(book -> book.getId() == id).findFirst();
    }
}
