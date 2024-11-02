package BookStore.UserService.Services;

import BookStore.UserService.DTOs.UserDto;
import BookStore.UserService.DTOs.UserDtoExtended;
import BookStore.UserService.Entities.Author;
import BookStore.UserService.Entities.Book;
import BookStore.UserService.Entities.User;
import BookStore.UserService.Repositories.AuthorRepository;
import BookStore.UserService.Repositories.BookRepository;
import BookStore.UserService.Repositories.UserRepository;
import BookStore.UserService.Services.Interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, AuthorRepository authorRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDtoExtended getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDtoExtended.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDto, user); // update user fields
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addBookToFavorites(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        user.getFavouriteBooks().add(book);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void addAuthorToFavorites(Long userId, Long authorId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));

        user.getFavouriteAuthors().add(author);
        userRepository.save(user);
    }
}

