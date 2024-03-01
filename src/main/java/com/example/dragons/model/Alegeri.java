package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alegeri1")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alegeri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alegere")
    private String alegere;

    @Column(name = "drum")
    private int drum;
}
