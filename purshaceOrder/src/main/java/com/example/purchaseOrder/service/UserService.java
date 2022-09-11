package com.example.purchaseOrder.service;

import com.example.purchaseOrder.entity.User;
import com.example.purchaseOrder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private MessageProduct messageProduct;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User create (User user) {
        var newOrder = userRepository.save(user);
//        messageProduct.sendMessage(newProduct);
        return newOrder;
    }

    public User update (User user) {
        if(user != null && !user.getId().isEmpty()){
            if(findById(user.getId()) != null)
                userRepository.save(user);
        }
        return null;
    }

    public void delete (String id) {
        userRepository.deleteById(id);
    }

    public void delete (User user) {
        userRepository.delete(user);
    }
}
