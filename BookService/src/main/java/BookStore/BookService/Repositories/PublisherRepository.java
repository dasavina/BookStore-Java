package BookStore.BookService.Repositories;


import BookStore.BookService.Entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}

