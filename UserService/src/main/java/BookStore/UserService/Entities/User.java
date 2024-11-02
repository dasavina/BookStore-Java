package BookStore.UserService.Entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "favourite_books",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "bookid")
    )
    private Set<Book> favouriteBooks;

    @ManyToMany
    @JoinTable(
            name = "favourite_authors",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    private Set<Author> favouriteAuthors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public void setFavouriteBooks(Set<Book> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public Set<Author> getFavouriteAuthors() {
        return favouriteAuthors;
    }

    public void setFavouriteAuthors(Set<Author> favouriteAuthors) {
        this.favouriteAuthors = favouriteAuthors;
    }
    // Getters and setters
}
