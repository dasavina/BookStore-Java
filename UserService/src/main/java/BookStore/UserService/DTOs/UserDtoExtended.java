package BookStore.UserService.DTOs;

import java.util.Set;

public class UserDtoExtended {
    private Long id;
    private String name;
    private String email;
    private Set<Long> favouriteBookIds; // IDs of favorite books
    private Set<Long> favouriteAuthorIds;

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

    public Set<Long> getFavouriteBookIds() {
        return favouriteBookIds;
    }

    public void setFavouriteBookIds(Set<Long> favouriteBookIds) {
        this.favouriteBookIds = favouriteBookIds;
    }

    public Set<Long> getFavouriteAuthorIds() {
        return favouriteAuthorIds;
    }

    public void setFavouriteAuthorIds(Set<Long> favouriteAuthorIds) {
        this.favouriteAuthorIds = favouriteAuthorIds;
    }
}
