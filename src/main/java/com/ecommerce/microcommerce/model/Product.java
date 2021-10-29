package com.ecommerce.microcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Product class which contain attributes :
 * id (int) , nom (String) , image (String) , prix (int)
 *
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String image;
    private int prix;

    //void constructor for the controller method add
    public Product() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(int id, String nom,String image, int prix) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", image='" + image + '\'' +
                '}';
    }
}
