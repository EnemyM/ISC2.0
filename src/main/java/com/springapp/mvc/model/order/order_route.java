package com.springapp.mvc.model.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 08.04.2016.
 */
@Entity
@Table(name = "order_route")
public class order_route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_route")
    private Integer id_order_route;

    @NotEmpty
    @Column(name = "start_route")
    private String start_route;

    @NotEmpty
    @Column(name = "end_route")
    private String end_route;

    @ManyToMany
    @JoinTable(name = "order_route_has_order",
            joinColumns = {@JoinColumn(name = "order_route_id_order_route")},
            inverseJoinColumns = {@JoinColumn(name = "order_id_order")})
    private Set<order> orders = new HashSet<order>();

    @OneToMany(mappedBy = "order_route", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<order_route_spot> order_route_spots = new HashSet<order_route_spot>();

    public Integer getId_order_route() {
        return id_order_route;
    }

    public void setId_order_route(Integer id_order_route) {
        this.id_order_route = id_order_route;
    }

    public String getStart_route() {
        return start_route;
    }

    public void setStart_route(String start_route) {
        this.start_route = start_route;
    }

    public String getEnd_route() {
        return end_route;
    }

    public void setEnd_route(String end_route) {
        this.end_route = end_route;
    }

    public Set<order> getOrders() {
        return orders;
    }

    public void setOrders(Set<order> orders) {
        this.orders = orders;
    }

    public Set<order_route_spot> getOrder_route_spots() {
        return order_route_spots;
    }

    public void setOrder_route_spots(Set<order_route_spot> order_route_spots) {
        this.order_route_spots = order_route_spots;
    }
    /* add order_route_spot into the order_route */
    public void addOrderRouteSpot(order_route_spot order_route_spot){
        order_route_spot.setOrder_route(this);
        getOrder_route_spots().add(order_route_spot);
    }
    /*remove order_route_spot from the order_route*/
    public void removeOrderRouteSpot(order_route_spot order_route_spot){
        getOrder_route_spots().remove(order_route_spot);
    }

    @Override
    public String toString() {
        return "order_route{" +
                "id_order_route=" + id_order_route +
                ", start_route='" + start_route + '\'' +
                ", end_route='" + end_route + '\'' +
                ", orders=" + orders +
                ", order_route_spots=" + order_route_spots +
                '}';
    }
}
