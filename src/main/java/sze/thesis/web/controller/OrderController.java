package sze.thesis.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sze.thesis.persistence.entity.Order;
import sze.thesis.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/myOrders")
    public List<Order> getMyOrders() {
        return orderService.findLoggedInUserOrders();
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }
}
