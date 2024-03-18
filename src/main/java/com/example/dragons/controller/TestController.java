package com.example.dragons.controller;

import com.example.dragons.model.Text1Alegeri1;
import com.example.dragons.repository.Text1Alegeri1Repository;
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

    public TestController(Text1Alegeri1Repository text1Alegeri1) {
        this.text1Alegeri1 = text1Alegeri1;
    }


//    @GetMapping
//    public List<Integer> datele(){
//        return new ArrayList<>(List.of(1,2,3,4,5,6));
//    }


    @GetMapping
        public ResponseEntity<List<Object>> metoda(@RequestParam(name = "val") Integer val){
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

        return ResponseEntity.ok(obj3);
    }
}
