package BookStore.BookService.Repositories;

import BookStore.BookService.Entities.BookPublisher;
import BookStore.BookService.Entities.BookPublisherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, BookPublisherId> {
}

