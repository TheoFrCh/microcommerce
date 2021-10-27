package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("ordinateur"), new String("https://gonzague.me/wp-content/uploads/2012/06/2439796349_56422d6e66.jpg"), 130));
        products.add(new Product(2, new String("chien"), new String("https://img-0.journaldunet.com/hz2q3APruWLlwjl0xC8EDx81ek8=/1500x/smart/8aa4a11f17834775aa0ec7afcebecaea/ccmcms-jdn/2056563.jpg"), 43));
        products.add(new Product(3, new String("oreiller"), new String("https://www.petiteamelie.fr/media/catalog/product/cache/9/thumbnail/1024x/85e4522595efc69f496374d01ef2bf13/o/r/oreiller-enfant-ensemble-couette-enfant.jpg"), 12));
        products.add(new Product(4, new String("clé à molette"), new String("https://www.sam-outillage.fr/data/produits/images/jpghdef/54-..._01.jpg"), 354));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product delete(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                return products.remove(i);
            }
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return product;
            }
        }
        return null;
    }
}
