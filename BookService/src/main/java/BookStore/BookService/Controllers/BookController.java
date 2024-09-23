package BookStore.BookService.Controllers;

import BookStore.BookService.Entities.Book;
import BookStore.BookService.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    // Handler method to display list of books
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // Handler method to show form to create new book
    @GetMapping("/books/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    // Handler method to save a new book
    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Handler method to show form to edit a book
    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit_book";
    }

    // Handler method to update an existing book
    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute("book") Book book) {

        // Fetch the existing book from the database by its ID
        Book existingBook = bookService.getBookById(id);

        // Update the fields with the new values from the form
        existingBook.setId(id);
        existingBook.setName(book.getName());
        existingBook.setDescription(book.getDescription());
        existingBook.setGenre(book.getGenre());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setCover(book.getCover());
        existingBook.setInStorage(book.isInStorage());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthorID(book.getAuthorID());

        // Save the updated book object
        bookService.updateBook(existingBook);

        return "redirect:/books";
    }


    // Handler method to delete a book
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
}
