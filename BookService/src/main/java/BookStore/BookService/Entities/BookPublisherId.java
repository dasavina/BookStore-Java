package BookStore.BookService.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookPublisherId implements Serializable {

    private Long bookId;
    private Long publisherId;

    // Constructors, Getters, Setters, Equals, and HashCode

    public BookPublisherId() {}

    public BookPublisherId(Long bookId, Long publisherId) {
        this.bookId = bookId;
        this.publisherId = publisherId;
    }

    // equals and hashCode
}
