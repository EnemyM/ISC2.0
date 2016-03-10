package com.springapp.mvc.model.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 25.01.2016.
 */
@Entity
@Table(name = "order_status")
public class order_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_status")
    private Integer id_order_status;

    @NotEmpty
    @Column(name = "order_status")
    private String order_status;

    @OneToMany(mappedBy = "order_status", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<order> orders = new HashSet<order>();

    public Integer getId_order_status() {
        return id_order_status;
    }

    public void setId_order_status(Integer id_order_status) {
        this.id_order_status = id_order_status;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Set<order> getOrders() {
        return orders;
    }

    public void setOrders(Set<order> orders) {
        this.orders = orders;
    }

    public String toString(){
        return "id order status: " + id_order_status + ", order status: " + order_status;
    }
}
