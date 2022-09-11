package com.example.purchaseOrder.service;

import com.example.purchaseOrder.entity.Product;
import com.example.purchaseOrder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private MessageProduct messageProduct;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product create (Product product) {
        var newProduct = productRepository.save(product);
//        messageProduct.sendMessage(newProduct);
        return newProduct;
    }

    public Product update (Product product) {
        if(product != null && !product.getId().isEmpty()){
            if(findById(product.getId()) != null)
                productRepository.save(product);
        }
        return null;
    }

    public void delete (String id) {
        productRepository.deleteById(id);
    }

    public void delete (Product product) {
        productRepository.delete(product);
    }
}
