package BookStore.BookService.Controllers;
import BookStore.BookService.Entities.BookPublisher;
import BookStore.BookService.Entities.BookPublisherId;
import BookStore.BookService.Services.BookPublisherService;
import BookStore.BookService.Services.BookService;
import BookStore.BookService.Services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookPublisherController {
    private final BookPublisherService bookPublisherService;
    private final BookService bookService;
    private final PublisherService publisherService;

    public BookPublisherController(BookPublisherService bookPublisherService, BookService bookService, PublisherService publisherService) {
        this.bookPublisherService = bookPublisherService;
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    // Display list of book-publisher links
    @GetMapping("/bookpublishers")
    public String listBookPublishers(Model model) {
        model.addAttribute("bookPublishers", bookPublisherService.getAll());
        return "book_publishers";
    }

    // Show form to create a new book-publisher link
    @GetMapping("/bookpublishers/new")
    public String createBookPublisherForm(Model model) {
        model.addAttribute("bookPublisher", new BookPublisher());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "create_book_publisher";
    }

    // Save a new book-publisher link
    @PostMapping("/bookpublishers")
    public String saveBookPublisher(@ModelAttribute("bookPublisher") BookPublisher bookPublisher) {
        bookPublisherService.save(bookPublisher);
        return "redirect:/book-publishers";
    }

    // Delete a book-publisher link
    @GetMapping("/bookpublishers/delete/{bookId}/{publisherId}")
    public String deleteBookPublisher(@PathVariable Long bookId, @PathVariable Long publisherId) {
        BookPublisherId id = new BookPublisherId(bookId, publisherId);
        bookPublisherService.delete(id);
        return "redirect:/bookpublishers";
    }
}

