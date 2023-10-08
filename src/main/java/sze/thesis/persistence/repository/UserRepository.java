package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);

    public User findByEmail(String email);
    public List<User> findAll();

    public User findByUsername(String username);
}
