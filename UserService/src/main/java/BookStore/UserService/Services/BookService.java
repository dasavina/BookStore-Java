package BookStore.UserService.Services;

import BookStore.UserService.Entities.Book;
import BookStore.UserService.Entities.Author;
import BookStore.UserService.Repositories.AuthorRepository;
import BookStore.UserService.Repositories.BookRepository;
import BookStore.UserService.DTOs.BookDto;
import BookStore.UserService.DTOs.BookDtoExtended;
import org.modelmapper.ModelMapper;
import BookStore.UserService.Services.Interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookDtoExtended getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book, BookDtoExtended.class);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        modelMapper.map(bookDto, book); // update book fields
        book.setAuthor(author);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
