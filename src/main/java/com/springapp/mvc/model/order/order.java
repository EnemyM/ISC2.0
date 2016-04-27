package com.springapp.mvc.model.order;

/**
 * Created by Anton on 24.01.2016.
 */

import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.model.user.user;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;


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

    @Column(name = "name_transport")
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

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,
    orphanRemoval = true)
//    private Set<product_order> products_order = new HashSet<product_order>();
    private List<product_order> products_order = LazyList.decorate(new ArrayList<product_order>(),
            FactoryUtils.instantiateFactory(product_order.class));

    @ManyToMany
    @JoinTable(name = "order_route_has_order",
            joinColumns = {@JoinColumn(name = "order_id_order")},
            inverseJoinColumns = {@JoinColumn(name = "order_route_id_order_route")})
    private Set<order_route> order_routes = new HashSet<order_route>();

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

    public List<product_order> getProducts_order() {
        return products_order;
    }

    public void setProducts_order(List<product_order> products_orders) {
        this.products_order = products_orders;
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

    @Override
    public String toString() {
        return "order{" +
                "id_order=" + id_order +
                ", date_order=" + date_order +
                ", date_delivery=" + date_delivery +
                ", time_delivery='" + time_delivery + '\'' +
                ", price_order=" + price_order +
                ", name_transport='" + name_transport + '\'' +
                ", user=" + user +
                ", order_status=" + order_status +
                ", transport=" + transport +
                ", order_spots=" + order_spots +
                ", products_order=" + products_order +
                ", order_routes=" + order_routes +
                '}';
    }
}
