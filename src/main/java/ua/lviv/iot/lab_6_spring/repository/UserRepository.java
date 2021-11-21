package ua.lviv.iot.lab_6_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab_6_spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
