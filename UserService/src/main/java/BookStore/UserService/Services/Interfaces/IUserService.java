package BookStore.UserService.Services.Interfaces;

import BookStore.UserService.DTOs.UserDto;
import BookStore.UserService.DTOs.UserDtoExtended;

import java.util.List;

public interface IUserService {

    UserDto createUser(UserDto createUserDto);

    UserDtoExtended getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
