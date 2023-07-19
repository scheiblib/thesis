package sze.thesis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sze.thesis.persistence.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
