package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    @Autowired //TODO C'est quoi ?
    private ProductDao productDao;

    //Products
    @GetMapping(value = "/products")
    public String productsList(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("listproducts", productDao.findAll());
        return "productsList";
    }

    @GetMapping(value = "/product/{id}")
    public String showOneProduct(@RequestParam(name = "name", required = false, defaultValue = "") String name, @PathVariable int id, Model model) {
        model.addAttribute("product", productDao.findById(id));
        return "product";
    }

    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.GET)
    public String showAddProductPage(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);

        return "addProduct";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }


    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.POST)
    public String saveProduct(Model model, //
                              @ModelAttribute("productForm") ProductForm productForm) {

        int id = productForm.getId();
        String nom = productForm.getNom();
        String image = productForm.getImage();
        int prix = productForm.getPrix();


        Product newProduct = new Product(id, nom, image, prix);
        ProductDaoImpl.products.add(newProduct);
        model.addAttribute("listproducts", productDao.findAll());

        return "productsList";
    }
}