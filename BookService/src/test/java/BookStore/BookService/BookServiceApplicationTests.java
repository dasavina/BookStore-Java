package BookStore.BookService;

import BookStore.BookService.Entities.Book;
import BookStore.BookService.Repositories.BookRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class BookServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldCreateBook() throws Exception {
        // Arrange
        Book book = getBookEntity();

        // Act
        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .when()
                .post("/api/book")
                .then()
                .log().all()
                .statusCode(201);

        // Assert: Check if the book was saved to the database
        Optional<Book> savedBook = bookRepository.findById(book.getId());
        assertThat(savedBook).isPresent();
        assertThat(savedBook.get().getName()).isEqualTo("book1");
        assertThat(savedBook.get().getGenre()).isEqualTo("genre1");
        assertThat(savedBook.get().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(100));
    }

    private Book getBookEntity() {
        // Create a Book entity with sample data
        Book book = new Book();
        book.setName("book1");
        book.setDescription("--");
        book.setGenre("genre1");
        book.setIsbn("isbn-1");
        book.setCover("cover url");
        book.setInStorage(false);
        book.setPrice(BigDecimal.valueOf(100));
        book.setAuthorID(1);
        return book;
    }
}
