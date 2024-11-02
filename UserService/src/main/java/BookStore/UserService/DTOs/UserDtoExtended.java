package BookStore.UserService.DTOs;

import java.util.Set;

public class UserDtoExtended {
    private Long id;
    private String name;
    private String email;
    private Set<Long> favouriteBookIds; // IDs of favorite books
    private Set<Long> favouriteAuthorIds;
}
