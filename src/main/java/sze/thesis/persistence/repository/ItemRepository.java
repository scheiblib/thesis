package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
