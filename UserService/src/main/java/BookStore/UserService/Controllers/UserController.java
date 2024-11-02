package BookStore.UserService.Controllers;

import BookStore.UserService.DTOs.UserDto;
import BookStore.UserService.DTOs.UserDtoExtended;
import BookStore.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto createUserDto) {
        UserDto userDto = userService.createUser(createUserDto);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoExtended> getUserById(@PathVariable Long id) {
        UserDtoExtended userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto createUserDto) {
        UserDto userDto = userService.updateUser(id, createUserDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/favorites/books/{bookId}")
    public ResponseEntity<Void> addBookToFavorites(@PathVariable Long userId, @PathVariable Long bookId) {
        userService.addBookToFavorites(userId, bookId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/favorites/authors/{authorId}")
    public ResponseEntity<Void> addAuthorToFavorites(@PathVariable Long userId, @PathVariable Long authorId) {
        userService.addAuthorToFavorites(userId, authorId);
        return ResponseEntity.ok().build();
    }
}

