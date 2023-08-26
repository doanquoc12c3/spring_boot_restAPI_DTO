package doanquoc.spring.springbootrestfulwebservices.mapper;

import doanquoc.spring.springbootrestfulwebservices.dto.UserDto;
import doanquoc.spring.springbootrestfulwebservices.entity.User;

public class UserMapper {

    // convert user jpa to userdto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
