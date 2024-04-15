package com.example.dragons.controller;

import com.example.dragons.model.*;
import com.example.dragons.repository.HeroesRepository;
import com.example.dragons.repository.Text1Alegeri1Repository;
import com.example.dragons.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/date")
@CrossOrigin("http://localhost:4200")
public class TestController {
    private final Text1Alegeri1Repository text1Alegeri1;
    private final UserRepository userRepository;
    private final HeroesRepository heroesRepository;

    public TestController(Text1Alegeri1Repository text1Alegeri1, UserRepository userRepository, HeroesRepository heroesRepository) {
        this.text1Alegeri1 = text1Alegeri1;
        this.userRepository = userRepository;
        this.heroesRepository = heroesRepository;
    }


//    @GetMapping
//    public List<Integer> datele(){
//        return new ArrayList<>(List.of(1,2,3,4,5,6));
//    }

    @PostMapping("/add")
    public ResponseEntity<Object> addHeroe(@RequestBody HeroesDto heroDto){
        User currentUser=userRepository.findById(User.ID).get();
        List<Heroes> heroes=heroesRepository.findByUserFk(User.ID);
        for(Heroes hero:heroes){
            if(hero.getName().equals(heroDto.name())){
                return ResponseEntity.ok().body("Erou cu asa nume deja exista");
            }
        }
        Heroes hero =new Heroes();
        hero.setHp(100);
        hero.setName(heroDto.name());
        hero.setClasa(heroDto.clasa());
        hero.setRoomId(1);
        hero.setUserFk(currentUser);
        if(heroDto.clasa().equals("Fighter")){
            hero.setStrength(3);
            hero.setDexterity(0);
            hero.setConstitution(3);
            hero.setIntelect(0);
            hero.setWisdom(2);
            hero.setCharizma(-1);
        }
        else if(heroDto.clasa().equals("Paladin")){
            hero.setStrength(3);
            hero.setDexterity(-1);
            hero.setConstitution(3);
            hero.setIntelect(-1);
            hero.setWisdom(0);
            hero.setCharizma(3);
        }
        else if(heroDto.clasa().equals("Wizard")){
            hero.setStrength(-1);
            hero.setDexterity(3);
            hero.setConstitution(-1);
            hero.setIntelect(3);
            hero.setWisdom(3);
            hero.setCharizma(0);
        }
       Heroes hero2= heroesRepository.save(hero);
       return ResponseEntity.ok().body(hero2);
    }

    @PostMapping("/heroes")
    public ResponseEntity<List<Heroes>> getHeroes(@RequestParam(name = "userId") Integer userId){
        List<Heroes> heroes=heroesRepository.findByUserFk(userId);
        return ResponseEntity.ok().body(heroes);
    }


    @PostMapping
    public ResponseEntity<RaspunsDto> metoda(@RequestParam(name = "roomId") Integer val){
        System.out.println(val);
        List<String> obj= text1Alegeri1.valorile2(val);
        List<String> obj2=new ArrayList<>();
        List<Object> obj3=new ArrayList<>();
        List<String> alegerile=new ArrayList<>();
        List<String> drumurile=new ArrayList<>();
        System.out.println(obj);

        for(String element:obj){
            String[] str=element.split(",");
            obj2.addAll(Arrays.asList(str));
        }
        for(int i=1;i<obj2.size();i+=3){
            alegerile.add(obj2.get(i));
        }
        for(int i=2;i<obj2.size();i+=3){
            drumurile.add(obj2.get(i));
        }

        if(alegerile.size()==2){
            alegerile.add("");
            drumurile.add("");
        }
        else if(alegerile.size()==1){
            alegerile.addAll(Arrays.asList("",""));
            drumurile.addAll(Arrays.asList("",""));
        }

        obj3.add(obj2.get(0));
        obj3.add(alegerile);
        obj3.add(drumurile);
        RaspunsDto raspuns=new RaspunsDto(obj2.get(0),alegerile,drumurile);

//        return ResponseEntity.ok(obj3);
        return ResponseEntity.ok(raspuns);
    }
}
