package com.springapp.mvc.model.order.products_order;

import com.springapp.mvc.model.order.order;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 03.02.2016.
 */
@Entity
@Table(name = "products_order")
public class products_order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products_order")
    private Integer id_products_order;

    @NotEmpty
    @Column(name = "amount_product")
    private String amount_product;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private product product;

    public Integer getId_products_order() {
        return id_products_order;
    }

    public void setId_products_order(Integer id_products_order) {
        this.id_products_order = id_products_order;
    }

    public String getAmount_product() {
        return amount_product;
    }

    public void setAmount_product(String amount_product) {
        this.amount_product = amount_product;
    }

    public order getOrder() {
        return order;
    }

    public void setOrder(order orders) {
        this.order = orders;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "products_order{" +
                "id_products_order=" + id_products_order +
                ", amount_product='" + amount_product + '\'' +
                ", orders=" + order +
                ", product=" + product +
                '}';
    }
}
