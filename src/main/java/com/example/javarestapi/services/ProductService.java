package com.example.javarestapi.services;

import com.example.javarestapi.entities.Product;
import com.example.javarestapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save(Product product){
        productRepository.save(product);

        return product;

    }

    public List<Product> list(){

        return productRepository.findAll();
    }


}