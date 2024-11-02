package BookStore.UserService.Services.Interfaces;

import BookStore.UserService.DTOs.AuthorDto;
import BookStore.UserService.DTOs.AuthorDtoExtended;

import java.util.List;

public interface IAuthorService {
    AuthorDto createAuthor(AuthorDto createAuthorDto);

    AuthorDtoExtended getAuthorById(Long id);

    List<AuthorDto> getAllAuthors();

    AuthorDto updateAuthor(Long id, AuthorDto createAuthorDto);

    void deleteAuthor(Long id);
}
