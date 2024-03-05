package com.example.dragons.controller;

import com.example.dragons.model.User;
import com.example.dragons.model.UserDto;
import com.example.dragons.model.UserDto2;
import com.example.dragons.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.Optional;

@RestController
@RequestMapping("/logIn")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody UserDto2 user) {
        System.out.println(user.login());
        Optional<User> user1=userRepository.findByLogin(user.login());
        if(user1.isEmpty()){
            try {
                throw new LoginException("Nu este username cu asa login");
            } catch (LoginException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu este username cu asa login");
            }
        }
        User user2=user1.get();
        if(!user2.getPassword().equals(user.password())){
            try {
                throw new LoginException("Parola este gresita");
            } catch (LoginException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parola este gresita");
            }
        }
        UserDto userDto=new UserDto(user2.getNickname(), user2.getRoomId());
        return ResponseEntity.ok(userDto);
    }
}
