package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
