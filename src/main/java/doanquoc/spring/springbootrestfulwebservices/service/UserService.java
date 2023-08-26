package doanquoc.spring.springbootrestfulwebservices.service;

import doanquoc.spring.springbootrestfulwebservices.dto.UserDto;
import doanquoc.spring.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, User user);

    void deleteUser(Long userId);


}
