package com.springapp.mvc.model.order.products_order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
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
    private Double product_cost;

    @NotEmpty
    @Column(name = "product_amount")
    private String product_amount;

    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "product_date_storage")
    private Date product_date_storage;

    @ManyToOne
    @JoinColumn(name = "id_product_type")
    private product_type product_type;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<products_order> products_orders = new HashSet<products_order>();

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

    public Double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Double product_cost) {
        this.product_cost = product_cost;
    }

    public String getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(String product_amount) {
        this.product_amount = product_amount;
    }

    public Date getProduct_date_storage() {
        return product_date_storage;
    }

    public void setProduct_date_storage(Date product_date_storage) {
        this.product_date_storage = product_date_storage;
    }

    public com.springapp.mvc.model.order.products_order.product_type getProduct_type() {
        return product_type;
    }

    public void setProduct_type(com.springapp.mvc.model.order.products_order.product_type product_type) {
        this.product_type = product_type;
    }

    public Set<products_order> getProducts_orders() {
        return products_orders;
    }

    public void setProducts_orders(Set<products_order> products_orders) {
        this.products_orders = products_orders;
    }

    public String toString(){
        return "id product: " + id_product + ", product name: " + product_name + ", product cost" + product_cost
                + ", product amount: " + product_amount + ", product date storage: " + product_date_storage;
    }
}
