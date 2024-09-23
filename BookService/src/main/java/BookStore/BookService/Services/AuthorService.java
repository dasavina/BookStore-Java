package BookStore.BookService.Services;
import BookStore.BookService.Entities.Author;

import java.util.List;


public interface AuthorService {

    List<Author> getAllAuthors();

    Author saveAuthor(Author author);

    Author getAuthorById(Long id);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);
}