package doanquoc.spring.springbootrestfulwebservices.service;

import doanquoc.spring.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);


}
