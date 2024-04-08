package com.example.dragons.controller;

import com.example.dragons.repository.AlegeriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GameController {


    private final AlegeriRepository alegeriRepository;

    public GameController(AlegeriRepository alegeriRepository) {
        this.alegeriRepository = alegeriRepository;
    }

    @GetMapping("/unu")
    private String firstLevel(Model model){
//        Alegeri alegere=alegeriRepository.findById(1);
        model.addAttribute("alegere1",alegeriRepository.findById(1).get());
        model.addAttribute("alegere2",alegeriRepository.findById(2).get());
        return "unu";
    }

    @PostMapping("/unu")
    private String procesare(@RequestParam(name = "al") String al,Model model){
        model.addAttribute("alegere1",alegeriRepository.findById(Integer.valueOf(al)).get());
        model.addAttribute("alegere2",alegeriRepository.findById(Integer.valueOf(al)).get());
        return "unu";
    }


}
