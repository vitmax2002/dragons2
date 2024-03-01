package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "text1_alegeri1")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Text1Alegeri1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "id_text1")
    private List<Texte> texte;

    @OneToMany
    @JoinColumn(name = "id_alegeri1")
    private List<Alegeri> alegeri;
}
