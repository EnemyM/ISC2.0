package com.springapp.mvc.model.order;

/**
 * Created by Anton on 24.01.2016.
 */

import com.springapp.mvc.model.user.user;
import com.springapp.mvc.model.order.products_order.products_order;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "order")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id_order;

    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "date_order")
    private Date date_order;

    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "date_delivery")
    private Date date_delivery;

    @NotEmpty
    @Column(name = "time_delivery")
    private String time_delivery;

    @NotEmpty
    @Column(name = "price_order")
    private Double price_order;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private user user;

    @ManyToOne
    @JoinColumn(name = "id_order_status")
    private order_status order_status;

    @ManyToMany
    @JoinTable(name = "orders_has_place_delivery",
                joinColumns = {@JoinColumn(name = "id_order")},
                 inverseJoinColumns = {@JoinColumn(name = "id_place_delivery")} )
    private Set<place_delivery> place_deliveries = new HashSet<place_delivery>();

    @ManyToMany
    @JoinTable(name = "place_store_has_orders",
            joinColumns= {@JoinColumn(name = "id_order")},
            inverseJoinColumns = {@JoinColumn(name = "id_place_store")})
    private Set<place_store> place_stores = new HashSet<place_store>();


    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<products_order> products_orders = new HashSet<products_order>();


    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(Date date_delivery) {
        this.date_delivery = date_delivery;
    }

    public String getTime_delivery() {
        return time_delivery;
    }

    public void setTime_delivery(String time_delivery) {
        this.time_delivery = time_delivery;
    }

    public Double getPrice_order() {
        return price_order;
    }

    public void setPrice_order(Double price_order) {
        this.price_order = price_order;
    }

    public com.springapp.mvc.model.user.user getUser() {
        return user;
    }

    public void setUser(com.springapp.mvc.model.user.user user) {
        this.user = user;
    }

    public com.springapp.mvc.model.order.order_status getOrder_status() {
        return order_status;
    }

    public void setOrder_status(com.springapp.mvc.model.order.order_status order_status) {
        this.order_status = order_status;
    }

    public Set<place_delivery> getPlace_deliveries() {
        return place_deliveries;
    }

    public void setPlace_deliveries(Set<place_delivery> place_deliveries) {
        this.place_deliveries = place_deliveries;
    }

    public Set<place_store> getPlace_stores() {
        return place_stores;
    }

    public void setPlace_stores(Set<place_store> place_stores) {
        this.place_stores = place_stores;
    }

    public Set<products_order> getProducts_orders() {
        return products_orders;
    }

    public void setProducts_orders(Set<products_order> products_orders) {
        this.products_orders = products_orders;
    }

    public String toString(){
        return "id order: " + id_order + ", date order: " + date_order + ", date delivery: " + date_delivery +
                ", time delivery: " + time_delivery + ", id user: " + user.getId_user() +
                ", id order status: " + order_status.getId_order_status();
    }
}
