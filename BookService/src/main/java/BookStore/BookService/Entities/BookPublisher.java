package BookStore.BookService.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class BookPublisher implements Serializable {

    @EmbeddedId
    private BookPublisherId id = new BookPublisherId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("publisherId")
    private Publisher publisher;

    // Constructors, Getters, Setters
    public BookPublisher() {}

    public BookPublisher(Book book, Publisher publisher) {
        this.book = book;
        this.publisher = publisher;
        this.id = new BookPublisherId(book.getId(), publisher.getId());
    }

    // getters and setters
}



