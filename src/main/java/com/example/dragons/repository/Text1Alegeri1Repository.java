package com.example.dragons.repository;

import com.example.dragons.model.Text1Alegeri1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Text1Alegeri1Repository extends JpaRepository<Text1Alegeri1,Integer> {

    @Query(nativeQuery = true,value = "SELECT text1.alegere, a.alegere, drum FROM text1_alegeri1 inner join text1" +
            " on text1.id=text1_alegeri1.id_text1" +
            " inner join alegeri1 as a" +
            " on a.id=text1_alegeri1.id_alegeri1" +
            " where text1.id=:val")
    List<String> valorile(@Param("val")int val);
}
