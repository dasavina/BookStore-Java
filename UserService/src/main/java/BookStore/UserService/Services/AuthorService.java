package BookStore.UserService.Services;

import BookStore.UserService.DTOs.AuthorDto;
import BookStore.UserService.DTOs.AuthorDtoExtended;
import BookStore.UserService.Entities.Author;
import BookStore.UserService.Repositories.AuthorRepository;
import BookStore.UserService.Services.Interfaces.IAuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;
@Service
public class AuthorService implements IAuthorService {


    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public AuthorDtoExtended getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return modelMapper.map(author, AuthorDtoExtended.class);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        modelMapper.map(authorDto, author); // update author fields
        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
