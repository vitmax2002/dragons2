package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "alegeri_alegeri")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Text1Alegeri1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "id_kk1")
    @Column(name = "id_kk1")
    private List<Alegeri> alegeri1;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "id_fk2")
    @Column(name = "id_fk2")
    private List<Alegeri> alegeri2;
}
