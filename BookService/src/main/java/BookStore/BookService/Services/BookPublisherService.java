package BookStore.BookService.Services;

import BookStore.BookService.Entities.BookPublisher;
import BookStore.BookService.Entities.BookPublisherId;

import java.util.List;

public interface BookPublisherService {
    List<BookPublisher> getAll();
    BookPublisher getById(BookPublisherId id);
    BookPublisher update(BookPublisher bookPublisher);
    void delete(BookPublisherId id);
    BookPublisher save(BookPublisher bookPublisher);
}
