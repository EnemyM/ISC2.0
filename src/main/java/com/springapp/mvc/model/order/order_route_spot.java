package com.springapp.mvc.model.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 08.04.2016.
 */
@Entity
@Table(name = "order_route_spot")
public class order_route_spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_route_spot")
    private Integer id_order_route_spot;

    @NotEmpty
    @Column(name = "name_spot")
    private String name_spot;

    @NotEmpty
    @Column(name = "road_path")
    private String road_path;

    @ManyToOne
    @JoinColumn(name = "id_order_route")
    order_route order_route;

    public Integer getId_order_route_spot() {
        return id_order_route_spot;
    }

    public void setId_order_route_spot(Integer id_order_route_spot) {
        this.id_order_route_spot = id_order_route_spot;
    }

    public String getName_spot() {
        return name_spot;
    }

    public void setName_spot(String name_spot) {
        this.name_spot = name_spot;
    }

    public String getRoad_path() {
        return road_path;
    }

    public void setRoad_path(String road_path) {
        this.road_path = road_path;
    }

    public com.springapp.mvc.model.order.order_route getOrder_route() {
        return order_route;
    }

    public void setOrder_route(com.springapp.mvc.model.order.order_route order_route) {
        this.order_route = order_route;
    }

    @Override
    public String toString() {
        return "order_route_spot{" +
                "id_order_route_spot=" + id_order_route_spot +
                ", name_spot='" + name_spot + '\'' +
                ", road_path='" + road_path + '\'' +
                ", order_route=" + order_route +
                '}';
    }
}
