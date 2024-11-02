package BookStore.BookService.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
public class Author {

    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="pseudonim")
    private String pseudonym;

    @Column(name="short_bio")
    private String shortBio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();


    public Author() {}

    public Author(Long id, String name, String pseudonym, String shortBio) {
        this.id = id;
        this.name = name;
        this.pseudonym = pseudonym;
        this.shortBio = shortBio;
    }

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

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

}
