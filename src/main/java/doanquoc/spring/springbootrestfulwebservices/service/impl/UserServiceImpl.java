package doanquoc.spring.springbootrestfulwebservices.service.impl;

import doanquoc.spring.springbootrestfulwebservices.dto.UserDto;
import doanquoc.spring.springbootrestfulwebservices.entity.User;
import doanquoc.spring.springbootrestfulwebservices.mapper.UserMapper;
import doanquoc.spring.springbootrestfulwebservices.respository.UserRepository;
import doanquoc.spring.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto create(UserDto userDto) {
        //Convert User Dto to User jpa entity
//        User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto,User.class);

        User savedUser = userRepository.save(user);

        //convert user jpa entity to user dto
//        UserDto savedUserDto =  UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        System.out.println(savedUserDto);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser =  userRepository.findById(userId);
        UserDto userDto = UserMapper.mapToUserDto(optionalUser.get());
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, User user) {

        User existingUser = userRepository.findById(userId).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return UserMapper.mapToUserDto(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
