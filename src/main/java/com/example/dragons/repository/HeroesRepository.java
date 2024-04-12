package com.example.dragons.repository;

import com.example.dragons.model.Heroes;
import com.example.dragons.model.HeroesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface HeroesRepository extends JpaRepository<Heroes,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM heroes " +
            "where user_fk = :userFk")
    List<Heroes> findByUserFk(@Param("userFk") int userFk);

//    @Query(select * from Heroes )

}
