package com.springapp.mvc.model.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 28.03.2016.
 */
@Entity
@Table(name = "transport")
public class transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transport")
    private Integer id_transport;

    @Column(name = "name_transport")
    private String name_transport;

    @Column(name = "min_tonnage")
    private String min_tonnage;

    @Column(name = "max_tonnage")
    private String max_tonnage;

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<order> orders = new HashSet<order>();

    public Integer getId_transport() {
        return id_transport;
    }

    public void setId_transport(Integer id_transport) {
        this.id_transport = id_transport;
    }

    public String getName_transport() {
        return name_transport;
    }

    public void setName_transport(String name_transport) {
        this.name_transport = name_transport;
    }

    public String getMin_tonnage() {
        return min_tonnage;
    }

    public void setMin_tonnage(String min_tonnage) {
        this.min_tonnage = min_tonnage;
    }

    public String getMax_tonnage() {
        return max_tonnage;
    }

    public void setMax_tonnage(String max_tonnage) {
        this.max_tonnage = max_tonnage;
    }

    public Set<order> getOrders() {
        return orders;
    }

    public void setOrders(Set<order> orders) {
        this.orders = orders;
    }

    public void addOrder(order order){
        order.setTransport(this);
        getOrders().add(order);
    }
    public void removeOrder(order order){
        getOrders().remove(order);
    }

    @Override
    public String toString() {
        return "transport{" +
                "id_transport=" + id_transport +
                ", name_transport='" + name_transport + '\'' +
                ", min_tonnage='" + min_tonnage + '\'' +
                ", max_tonnage='" + max_tonnage + '\'' +
                ", orders=" + orders +
                '}';
    }
}
