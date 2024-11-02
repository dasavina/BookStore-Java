package BookStore.UserService.Services.Interfaces;

import BookStore.UserService.DTOs.BookDto;
import BookStore.UserService.DTOs.BookDtoExtended;

import java.util.List;

public interface IBookService {
    BookDto createBook(BookDto createBookDto);

    BookDtoExtended getBookById(Long id);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long id, BookDto createBookDto);

    void deleteBook(Long id);
}
