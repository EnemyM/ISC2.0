package com.springapp.mvc.model.order;

import com.springapp.mvc.model.order.products_order.product_order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 26.04.2016.
 */
@Entity
public class order_spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_spot")
    private Integer id_order_spot;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "spot_type")
    private String name_spot_type;

    @ManyToOne
    @JoinColumn(name = "id_spot_type")
    private spot_type spot_type;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private order order;

    @OneToMany(mappedBy = "order_spot",cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<product_order> products_order = new HashSet<product_order>();

    private Integer hashCode;

    public Integer getId_order_spot() {
        return id_order_spot;
    }

    public void setId_order_spot(Integer id_order_spot) {
        this.id_order_spot = id_order_spot;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName_spot_type() {
        return name_spot_type;
    }

    public void setName_spot_type(String name_spot_type) {
        this.name_spot_type = name_spot_type;
    }

    public com.springapp.mvc.model.order.spot_type getSpot_type() {
        return spot_type;
    }

    public void setSpot_type(com.springapp.mvc.model.order.spot_type spot_type) {
        this.spot_type = spot_type;
    }

    public com.springapp.mvc.model.order.order getOrder() {
        return order;
    }

    public void setOrder(com.springapp.mvc.model.order.order order) {
        this.order = order;
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
    }

    public Set<product_order> getProducts_order() {
        return products_order;
    }

    public void setProducts_order(Set<product_order> products_order) {
        this.products_order = products_order;
    }

    public void addProduct(product_order product){
        product.setOrder_spot(this);
        getProducts_order().add(product);
    }

    public void removeProduct(product_order product){
        getProducts_order().remove(product);
    }
    @Override
    public String toString() {
        return "order_spot{" +
                "id_order_spot=" + id_order_spot +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name_spot_type='" + name_spot_type + '\'' +
                ", spot_type=" + spot_type +
                ", order=" + order +
                ", hashCode=" + hashCode +
                '}';
    }
}
