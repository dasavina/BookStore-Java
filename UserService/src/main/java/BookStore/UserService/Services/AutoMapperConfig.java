package BookStore.UserService.Services;

import BookStore.UserService.DTOs.*;
import BookStore.UserService.Entities.Author;
import BookStore.UserService.Entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.print.Book;

@Configuration
public class AutoMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Configure mappings between entities and DTOs
        modelMapper.typeMap(User.class, UserDto.class);
        modelMapper.typeMap(UserDto.class, User.class);

        modelMapper.typeMap(Book.class, BookDto.class);
        modelMapper.typeMap(BookDto.class, Book.class);

        modelMapper.typeMap(Author.class, AuthorDto.class);
        modelMapper.typeMap(AuthorDto.class, Author.class);

        modelMapper.typeMap(User.class, UserDtoExtended.class);
        modelMapper.typeMap(UserDtoExtended.class, User.class);

        modelMapper.typeMap(Book.class, BookDtoExtended.class);
        modelMapper.typeMap(BookDtoExtended.class, Book.class);

        modelMapper.typeMap(Author.class, AuthorDtoExtended.class);
        modelMapper.typeMap(AuthorDtoExtended.class, Author.class);

        return modelMapper;
    }
}

