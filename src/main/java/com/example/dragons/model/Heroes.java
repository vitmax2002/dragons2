package com.example.dragons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "heroes")
public class Heroes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "class")
    private String clasa;
    @Column(name = "constitution")
    private Integer constitution;
    @Column(name = "strength")
    private Integer strength;
    @Column(name = "intelect")
    private Integer intelect;
    @Column(name = "charizma")
    private Integer charizma;
    @Column(name = "wisdom")
    private Integer wisdom;
    @Column(name = "dexterity")
    private Integer dexterity;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    @JsonIgnore
    private User userFk;
}
