package com.example.dragons.controller;

import com.example.dragons.model.*;
import com.example.dragons.repository.HeroesRepository;
import com.example.dragons.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logIn")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    private final UserRepository userRepository;
    private final HeroesRepository heroesRepository;

    public LoginController(UserRepository userRepository, HeroesRepository heroesRepository) {
        this.userRepository = userRepository;
        this.heroesRepository = heroesRepository;
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
        User.ID=user2.getId();
//        List<Heroes> heroes = heroesRepository.findByUserFk(user2.getId());
//        List<HeroesDto> heroseDto =new ArrayList<>();
//        for(var hero: heroes){
//            heroseDto.add(new HeroesDto(hero.getId(),hero.getHp(),hero.getName(),hero.getClasa(),hero.getRoomId()));
//        }
        UserDto userDto=new UserDto(user2.getUsername(), user2.getId());
        return ResponseEntity.ok(userDto);
    }
}
