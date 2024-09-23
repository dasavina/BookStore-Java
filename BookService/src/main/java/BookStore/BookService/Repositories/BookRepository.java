package BookStore.BookService.Repositories;

import BookStore.BookService.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long>{
}
