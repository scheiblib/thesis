package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sze.thesis.persistence.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
}
