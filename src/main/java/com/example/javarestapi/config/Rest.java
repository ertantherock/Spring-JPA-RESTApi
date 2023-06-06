package com.example.javarestapi.config;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rest {

    private boolean status;
    private Object result;
}
