package com.example.dragons.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "heroes")
public class Heroes {
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
    @Column(name = "constitution", columnDefinition = "int default 0")
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    private User userFk;
}
