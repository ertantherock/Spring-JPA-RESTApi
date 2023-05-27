package com.example.javarestapi.restcontroller;

import com.example.javarestapi.entities.Product;
import com.example.javarestapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {

        return productService.save(product);
    }

    @GetMapping("/list")
    public List<Product> list(){

        return productService.list();
    }



}
