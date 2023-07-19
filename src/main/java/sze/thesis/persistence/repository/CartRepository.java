package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
