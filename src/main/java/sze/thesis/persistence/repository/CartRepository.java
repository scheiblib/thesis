package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sze.thesis.persistence.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
