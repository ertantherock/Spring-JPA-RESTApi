package com.example.javarestapi.services;

import com.example.javarestapi.config.Rest;
import com.example.javarestapi.entities.Product;
import com.example.javarestapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity save(Product product){
        try {
            productRepository.save(product);
            Rest rest = new Rest(true,product);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception exception){
            Rest rest = new Rest(false, exception.getMessage());//Message ile daha açıklayıcı hata veririz.
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity list(){ //Response Entity ? soru işareti alırsa bu onun customer httpstatus gönderebilir
        //demek oluyor.

        List<Product> ls = productRepository.findAll();

        Rest rest = new Rest(true, ls);//Burayı Rest classındaki status ve objecte göre yaptık ki dönen response
        //API standartlarına uygun olabilsin.

        return new ResponseEntity(rest,  HttpStatus.OK);
    }


}
