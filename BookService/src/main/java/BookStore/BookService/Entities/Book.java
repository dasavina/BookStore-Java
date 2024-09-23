package BookStore.BookService.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long id;

    @Column(name = "name")
    private String Name;
    @Column(name = "description")
    private String description;
    @Column(name = "genre")
    private String genre;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "cover")
    private String cover;
    @Column(name = "inStorage")
    private boolean inStorage;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "authorID")
    private int authorID;

    public Book(Long id, String name, String description, String genre, String isbn, String cover, boolean inStorage, BigDecimal price, int authorID) {
        this.id = id;
        Name = name;
        this.description = description;
        this.genre = genre;
        this.isbn = isbn;
        this.cover = cover;
        this.inStorage = inStorage;
        this.price = price;
        this.authorID = authorID;
    }

    public Book() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public boolean isInStorage() {
        return inStorage;
    }

    public void setInStorage(boolean inStorage) {
        this.inStorage = inStorage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
