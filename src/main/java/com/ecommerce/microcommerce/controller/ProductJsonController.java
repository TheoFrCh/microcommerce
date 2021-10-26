package com.rent.rent.controller;


import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //The answer will be Json
public class ProductJsonController {

    @Autowired //TODO C'est quoi ?
    private ProductDao productDao;

    //Products
    @GetMapping(value = "productsJson")
    public List<Product> listproducts(){
        return productDao.findAll();
    }

    //Products/{id}
    @GetMapping(value = "products/{id}") //Call this methode only for a get request
    public Product displayProduct(@PathVariable int id){
        return productDao.findById(id);
    }
}