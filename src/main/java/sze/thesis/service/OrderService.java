package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sze.thesis.model.OrderDto;
import sze.thesis.persistence.entity.Item;
import sze.thesis.persistence.entity.Order;
import sze.thesis.persistence.repository.OrderRepository;

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

    public void createOrder(){
        Order o = new Order();
        o.setStatus("Függőben");
//        TODO: get logged in user
//        o.setUser();

    }
    public void addItemToOrder(long itemId, int count){
        Item i = itemService.findItemById(itemId);
        Order o = new Order();
        o.getItems().add(i);
    }
}
