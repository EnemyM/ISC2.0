package com.springapp.mvc.model.order.products_order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 25.01.2016.
 */
@Entity
@Table(name = "product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id_product;

    @NotEmpty
    @Column(name = "product_name")
    private String product_name;

    @NotEmpty
    @Column(name = "product_cost")
    private String product_cost;

    @NotEmpty
    @Column(name = "product_amount")
    private String product_amount;

    @NotEmpty
    @Column(name = "product_date_storage")
    private String product_date_storage;


    @ManyToOne
    @JoinColumn(name = "id_product_type")
    private product_type product_type;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<product_order> products_orders = new HashSet<product_order>();

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(String product_cost) {
        this.product_cost = product_cost;
    }

    public String getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(String product_amount) {
        this.product_amount = product_amount;
    }

    public String getProduct_date_storage() {
        return product_date_storage;
    }

    public void setProduct_date_storage(String product_date_storage) {
        this.product_date_storage = product_date_storage;
    }

    public com.springapp.mvc.model.order.products_order.product_type getProduct_type() {
        return product_type;
    }

    public void setProduct_type(com.springapp.mvc.model.order.products_order.product_type product_type) {
        this.product_type = product_type;
    }

    public Set<product_order> getProducts_orders() {
        return products_orders;
    }


    public void setProducts_orders(Set<product_order> products_orders) {
        this.products_orders = products_orders;
    }
    public void addProductOrder(product_order product){
        product.setProduct(this);
        getProducts_orders().add(product);
    }
    public void removeProductOrder(product_order product){
        getProducts_orders().remove(product);
    }

    @Override
    public String toString() {
        return "product{" +
                "id_product=" + id_product +
                ", product_name='" + product_name + '\'' +
                ", product_cost='" + product_cost + '\'' +
                ", product_amount='" + product_amount + '\'' +
                ", product_date_storage=" + product_date_storage +
                ", product_type=" + product_type +
                ", products_orders=" + products_orders +
                '}';
    }
}
