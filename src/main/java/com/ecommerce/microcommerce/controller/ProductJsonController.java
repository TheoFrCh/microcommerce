package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //The answer will be Json
public class ProductJsonController {

    @Autowired
    private ProductDao productDao;

    //Products
    @GetMapping(value = "products")
    public List<Product> listproducts(){ return productDao.findAll();}

    //Products/{id}
    @GetMapping(value = "products/{id}") //Call this methode only for a get request
    public Product displayProduct(@PathVariable int id){
        return productDao.findById(id);
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){

        Product product1 = productDao.save(product);

        if (product == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping(value = "/product/{prixLimit}")
    public List<Product> testDeRequetes(@PathVariable int prixLimit){
        return productDao.findByPrixGreaterThan(prixLimit);
    }

}