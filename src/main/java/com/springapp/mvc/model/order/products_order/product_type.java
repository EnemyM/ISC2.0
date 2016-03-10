package com.springapp.mvc.model.order.products_order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 25.01.2016.
 */
@Entity
@Table(name = "product_type")
public class product_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_type")
    private Integer id_product_type;

    @NotEmpty
    @Column(name = "product_type")
    private String product_type;

    @OneToMany(mappedBy = "product_type", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<product> products = new HashSet<product>();


    public Integer getId_product_type() {
        return id_product_type;
    }

    public void setId_product_type(Integer id_product_type) {
        this.id_product_type = id_product_type;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public Set<product> getProducts() {
        return products;
    }

    public void setProducts(Set<product> products) {
        this.products = products;
    }


    public String toString(){
        return "id product type: " + ", type product: " + product_type;
    }
}
