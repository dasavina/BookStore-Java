package BookStore.BookService.Controllers;

import BookStore.BookService.Entities.Author;
import BookStore.BookService.Services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    // Handler method to display list of authors
    @GetMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    // Handler method to show form to create new author
    @GetMapping("/authors/new")
    public String createAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "create_author";
    }

    // Handler method to save a new author
    @PostMapping("/authors")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    // Handler method to show form to edit an author
    @GetMapping("/authors/edit/{id}")
    public String editAuthorForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "edit_author";
    }

    // Handler method to update an existing author
    @PostMapping("/authors/{id}")
    public String updateAuthor(@PathVariable Long id,
                               @ModelAttribute("author") Author author) {

        Author existingAuthor = authorService.getAuthorById(id);
        existingAuthor.setId(id);
        existingAuthor.setName(author.getName());
        existingAuthor.setPseudonym(author.getPseudonym());
        existingAuthor.setShortBio(author.getShortBio());

        authorService.updateAuthor(existingAuthor);
        return "redirect:/authors";
    }

    // Handler method to delete an author
    @GetMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
