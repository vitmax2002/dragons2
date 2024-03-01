package com.example.dragons.controller;

import com.example.dragons.model.User;
import com.example.dragons.model.UserDto;
import com.example.dragons.model.UserDto2;
import com.example.dragons.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/logIn")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserDto> login(@RequestBody UserDto2 user){
        User user1=userRepository.findByUsername(user.username()).get();
        UserDto userDto=new UserDto(user1.getUsername(), user1.getRoomId());
        return ResponseEntity.ok(userDto);
    }
}
