package com.springapp.mvc.model.order.products_order;

import com.springapp.mvc.model.order.order;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 03.02.2016.
 */
@Entity
@Table(name = "product_order")
public class product_order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_order")
    private Integer id_product_order;

    @NotEmpty
    @Column(name = "amount_product")
    private String amount_product;

    @NotEmpty
    @Column(name = "price_amount")
    private Double price_amount;

    @Column(name = "product_name")
    private String product_name;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private product product;

    public Integer getId_product_order() {
        return id_product_order;
    }

    public void setId_product_order(Integer id_product_order) {
        this.id_product_order = id_product_order;
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

    public Double getPrice_amount() {
        return price_amount;
    }

    public void setPrice_amount(Double price_amount) {
        this.price_amount = price_amount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "product_order{" +
                "id_product_order=" + id_product_order +
                ", amount_product='" + amount_product + '\'' +
                ", price_amount='" + price_amount + '\'' +
                ", product_name='" + product_name + '\'' +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
