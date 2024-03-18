package com.example.dragons.repository;

import com.example.dragons.model.Text1Alegeri1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Text1Alegeri1Repository extends JpaRepository<Text1Alegeri1,Integer> {

//    @Query(nativeQuery = true,value = "SELECT text1.alegere, a.alegere, drum FROM text1_alegeri1 inner join text1" +
//            " on text1.id=text1_alegeri1.id_text1" +
//            " inner join alegeri1 as a" +
//            " on a.id=text1_alegeri1.id_alegeri1" +
//            " where text1.id=:val")
//    List<String> valorile(@Param("val")int val);

    @Query(nativeQuery = true,value = "select a.textul, a2.textul,a2.id from alegeri as a" +
            " inner join alegeri_alegeri as aa" +
            " on a.id=aa.id_kk1" +
            " inner join alegeri as a2" +
            " on a2.id=aa.id_fk2" +
            " where aa.id_kk1= :val")
    List<String> valorile2(@Param("val")int val);
}
