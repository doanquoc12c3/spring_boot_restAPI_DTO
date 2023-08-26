package doanquoc.spring.springbootrestfulwebservices.service;

import doanquoc.spring.springbootrestfulwebservices.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto user);

    void deleteUser(Long userId);


}
