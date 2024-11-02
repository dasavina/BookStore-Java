package BookStore.UserService.Controllers;

import BookStore.UserService.DTOs.AuthorDto;
import BookStore.UserService.DTOs.AuthorDtoExtended;
import BookStore.UserService.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto createAuthorDto) {
        AuthorDto authorDto = authorService.createAuthor(createAuthorDto);
        return ResponseEntity.ok(authorDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDtoExtended> getAuthorById(@PathVariable Long id) {
        AuthorDtoExtended authorDto = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorDto);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto createAuthorDto) {
        AuthorDto authorDto = authorService.updateAuthor(id, createAuthorDto);
        return ResponseEntity.ok(authorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}

