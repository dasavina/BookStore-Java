package BookStore.UserService.Controllers;

import BookStore.UserService.DTOs.BookDto;
import BookStore.UserService.DTOs.BookDtoExtended;
import BookStore.UserService.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto createBookDto) {
        BookDto bookDto = bookService.createBook(createBookDto);
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDtoExtended> getBookById(@PathVariable Long id) {
        BookDtoExtended bookDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto createBookDto) {
        BookDto bookDto = bookService.updateBook(id, createBookDto);
        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

