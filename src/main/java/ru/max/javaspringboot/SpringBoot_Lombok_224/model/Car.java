package ru.max.javaspringboot.SpringBoot_Lombok_224.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "price")
    private double price;

    @Setter
    @Getter
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;
}
