package doanquoc.spring.springbootrestfulwebservices.controller;

import doanquoc.spring.springbootrestfulwebservices.dto.UserDto;
import doanquoc.spring.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST api

    @PostMapping
    public ResponseEntity<UserDto>  createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.create(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id rest api
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // build get all user rest api
    // http://localhost:8080/api/users
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // build update user rest api
    // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto user){
        UserDto updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }







}
