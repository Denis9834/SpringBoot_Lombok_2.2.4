package ru.max.javaspringboot.SpringBoot_Lombok_224.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "income")
    private Double income;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @Getter
    @Setter
    private Car car;
}
