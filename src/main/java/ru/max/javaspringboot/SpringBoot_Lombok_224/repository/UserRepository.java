package ru.max.javaspringboot.SpringBoot_Lombok_224.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.javaspringboot.SpringBoot_Lombok_224.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
