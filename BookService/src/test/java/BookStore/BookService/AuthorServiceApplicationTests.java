package BookStore.BookService;

import BookStore.BookService.Entities.Author;
import BookStore.BookService.Repositories.AuthorRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class AuthorServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldCreateAuthor() throws Exception {
        // Arrange
        Author author = getAuthorEntity();

        // Act
        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(author)
                .when()
                .post("/api/author")
                .then()
                .log().all()
                .statusCode(201);

        // Assert: Check if the author was saved to the database
        Optional<Author> savedAuthor = authorRepository.findById(author.getId());
        assertThat(savedAuthor).isPresent();
        assertThat(savedAuthor.get().getName()).isEqualTo("Author Name");
        assertThat(savedAuthor.get().getShortBio()).isEqualTo("Author short bio");
    }

    private Author getAuthorEntity() {
        // Create an Author entity with sample data
        Author author = new Author();
        author.setName("Author Name");
        author.setPseudonym("author1");
        author.setShortBio("Author short bio");
        return author;
    }
}
