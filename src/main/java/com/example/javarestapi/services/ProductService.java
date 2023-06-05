package com.example.javarestapi.services;

import com.example.javarestapi.entities.Product;
import com.example.javarestapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public boolean delete(Long pid){
        try {
            productRepository.deleteById(pid);
            return true;
        }catch (Exception ex){
            System.err.println("Delete Error"+ ex);
            return false;
        }

    }

    public Product update(Product product){
        //Önce Veri Tabanına uğra ve update edilmek istenen nesnenin var olup olmadığını denetle.
        //Çünkü ID yoksa update değil Insert yapar.
        Optional<Product> optionalProduct = productRepository.findById(product.getPid());
        if (optionalProduct.isPresent()) {
            //isPresent ile optionalProduct'ın olup olmadığını doğruladık. Eğer varsa if içi dolaşır.
            productRepository.saveAndFlush(product);
            return product;

        }
        //başarısızsa null döner
        return null;
    }


}
