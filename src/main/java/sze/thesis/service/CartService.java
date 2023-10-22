package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sze.thesis.persistence.entity.Cart;
import sze.thesis.persistence.repository.CartRepository;
import sze.thesis.persistence.repository.ItemRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Cart getCart(){
        return (Cart)cartRepository.findAll();
    }

    public void addItemToCart(long itemId) {
        if(getCart() == null){
            Cart cart = new Cart();
            cart.getItems().add(itemRepository.findById(itemId));
        } else{

        }

    }
}
