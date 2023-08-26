package doanquoc.spring.springbootrestfulwebservices.service.impl;

import doanquoc.spring.springbootrestfulwebservices.entity.User;
import doanquoc.spring.springbootrestfulwebservices.respository.UserRepository;
import doanquoc.spring.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser =  userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users;
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
