package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alegeri")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alegeri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "textul")
    private String alegere;

//    @Column(name = "drum")
//    private Integer drum;

    @Column(name = "textul2")
    private String text;

    @Column(name = "type")
    private String type;

    @Column(name = "roll_count")
    private Integer rollCount;

    @Column(name = "max_rand")
    private Integer maxRand;

    @Column(name = "roll_score")
    private Integer rollScore;
}
