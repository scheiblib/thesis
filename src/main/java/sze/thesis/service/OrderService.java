package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sze.thesis.model.OrderDto;
import sze.thesis.persistence.entity.Item;
import sze.thesis.persistence.entity.Order;
import sze.thesis.persistence.entity.User;
import sze.thesis.persistence.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    public Order findOrderById(long id){
        return orderRepository.findById(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order createOrder(User u){
        return Order.builder().status("Függőben")
                .createdAt(LocalDateTime.now())
                .items(new ArrayList<>())
                .user(u)
                .build();
    }
    public void addItemToOrder(long itemId, int count, User user){
        Item item = itemService.findItemById(itemId);
        for(Order order : user.getOrders()){
            if(order.getStatus().equals("Függőben")){
                order.getItems().add(item);
            } else {
                Order newOrder = createOrder(user);
                newOrder.getItems().add(item);
            }
        }
    }
}
