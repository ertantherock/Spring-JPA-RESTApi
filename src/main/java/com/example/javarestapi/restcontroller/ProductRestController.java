package com.example.javarestapi.restcontroller;

import com.example.javarestapi.entities.Product;
import com.example.javarestapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {

        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list(){

        return productService.list();
    }



}
