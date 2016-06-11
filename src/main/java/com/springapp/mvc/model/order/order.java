package com.springapp.mvc.model.order;

/**
 * Created by Anton on 24.01.2016.
 */

import com.springapp.mvc.model.user.user;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Entity
@Table(name = "order")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id_order;

    @NotEmpty
    @Column(name = "date_delivery")
    private String date_delivery;

    @NotEmpty
    @Column(name = "time_delivery")
    private String time_delivery;

    @NotEmpty
    @Column(name = "date_order")
    private String date_order;

    @NotEmpty
    @Column(name = "price_order")
    private String price_order;

    private String name_transport;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private user user;

    @ManyToOne
    @JoinColumn(name = "id_order_status")
    private order_status order_status;

    @ManyToOne
    @JoinColumn(name = "id_transport")
    private transport transport;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<order_spot> order_spots = new HashSet<order_spot>();

    @ManyToMany
    @JoinTable(name = "order_route_has_order",
            joinColumns = {@JoinColumn(name = "order_id_order")},
            inverseJoinColumns = {@JoinColumn(name = "order_route_id_order_route")})
    private Set<order_route> order_routes = new HashSet<order_route>();


    public order() {
    }

    public order(Integer id_order, String date_order, String date_delivery, String time_delivery, String price_order) {
        this.id_order = id_order;
        this.date_order = date_order;
        this.date_delivery = date_delivery;
        this.time_delivery = time_delivery;
        this.price_order = price_order;
    }

    public String getName_transport() {
        return name_transport;
    }

    public void setName_transport(String name_transport) {
        this.name_transport = name_transport;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }

    public String getTime_delivery() {
        return time_delivery;
    }

    public void setTime_delivery(String time_delivery) {
        this.time_delivery = time_delivery;
    }

    public String getPrice_order() {
        return price_order;
    }

    public void setPrice_order(String price_order) {
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


    public com.springapp.mvc.model.order.transport getTransport() {
        return transport;
    }

    public void setTransport(com.springapp.mvc.model.order.transport transport) {
        this.transport = transport;
    }

    public Set<order_route> getOrder_routes() {
        return order_routes;
    }

    public void setOrder_routes(Set<order_route> order_routes) {
        this.order_routes = order_routes;
    }


    public Set<order_spot> getOrder_spots() {
        return order_spots;
    }

    public void setOrder_spots(Set<order_spot> order_spots) {
        this.order_spots = order_spots;
    }

    /* some methods to add contained entities into the order */
    public void addOrderSpot(order_spot spot){
        spot.setOrder(this);
        getOrder_spots().add(spot);
    }
    public void addAllOrderSpots(Set<order_spot> spots){
        for (Iterator<order_spot> i = spots.iterator(); i.hasNext();){
            order_spot current = i.next();
            current.setOrder(this);
            getOrder_spots().add(current);
        }
    }
    public void  removeOrderSpot(order_spot spot){
        getOrder_spots().remove(spot);
    }
    @Override
    public String toString() {
        return "order{" +
                "id_order=" + id_order +
                ", date_order=" + date_order +
                ", date_delivery=" + date_delivery +
                ", time_delivery='" + time_delivery + '\'' +
                ", price_order=" + price_order +
                /*", name_transport='" + name_transport + '\'' +*/
                ", user=" + user +
                ", order_status=" + order_status +
                ", transport=" + transport +
                ", order_spots=" + order_spots +
                ", order_routes=" + order_routes +
                '}';
    }
}
