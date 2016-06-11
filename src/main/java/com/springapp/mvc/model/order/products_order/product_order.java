package com.springapp.mvc.model.order.products_order;

import com.springapp.mvc.model.order.order_spot;
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


    private String product_name;

    @ManyToOne
    @JoinColumn(name = "id_order_spot")
    private order_spot order_spot;

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

    public order_spot getOrder_spot() {
        return order_spot;
    }

    public void setOrder_spot(order_spot order_spots) {
        this.order_spot = order_spots;
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
                ", order_spot=" + order_spot +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        product_order that = (product_order) o;

        if (id_product_order != null ? !id_product_order.equals(that.id_product_order) : that.id_product_order != null)
            return false;
        if (amount_product != null ? !amount_product.equals(that.amount_product) : that.amount_product != null)
            return false;
        if (price_amount != null ? !price_amount.equals(that.price_amount) : that.price_amount != null) return false;
        if (product_name != null ? !product_name.equals(that.product_name) : that.product_name != null) return false;
        if (order_spot != null ? !order_spot.equals(that.order_spot) : that.order_spot != null) return false;
        return !(product != null ? !product.equals(that.product) : that.product != null);

    }

    @Override
    public int hashCode() {
        int result = id_product_order != null ? id_product_order.hashCode() : 0;
        result = 31 * result + (amount_product != null ? amount_product.hashCode() : 0);
        result = 31 * result + (price_amount != null ? price_amount.hashCode() : 0);
        result = 31 * result + (product_name != null ? product_name.hashCode() : 0);
        result = 31 * result + (order_spot != null ? order_spot.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
