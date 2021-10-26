package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller//The answer will be Json
public class ProductController {

    @Autowired //TODO C'est quoi ?
    private ProductDao productDao;

    //Products
    @GetMapping(value = "/products")
    public String productsList(@RequestParam(name="name", required=false, defaultValue="") String name, Model model) {
        model.addAttribute("listproducts", productDao.findAll());
        return "productsList";
    }
}