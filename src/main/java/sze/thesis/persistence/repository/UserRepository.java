package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByEmail(String email);
    List<User> findAll();
}
