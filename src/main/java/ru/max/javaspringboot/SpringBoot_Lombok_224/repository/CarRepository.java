package ru.max.javaspringboot.SpringBoot_Lombok_224.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.javaspringboot.SpringBoot_Lombok_224.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
