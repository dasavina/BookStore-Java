package BookStore.BookService.Services.Implementations;

import java.util.List;

import BookStore.BookService.Entities.Author;
import BookStore.BookService.Repositories.AuthorRepository;
import BookStore.BookService.Services.AuthorService;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        super();
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return  authorRepository.findById(id).get();
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}

