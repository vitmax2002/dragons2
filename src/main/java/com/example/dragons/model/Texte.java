package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "text1")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Texte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alegere")
    private String alegere;
}
