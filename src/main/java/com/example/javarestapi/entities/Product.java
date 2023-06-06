package com.example.javarestapi.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(unique = true)
    private String title;

    private String detail;

    @Column(unique = true)
    private Integer price;

    private  Boolean status;

}
