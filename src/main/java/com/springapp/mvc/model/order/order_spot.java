package com.springapp.mvc.model.order;

import javax.persistence.*;

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
    private String spot_rype;

    @ManyToOne
    @JoinColumn(name = "id_spot_type")
    private spot_type spot_type;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private order order;

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

    public com.springapp.mvc.model.order.spot_type getSpot_type() {
        return spot_type;
    }

    public void setSpot_type(com.springapp.mvc.model.order.spot_type spot_type) {
        this.spot_type = spot_type;
    }

    public String getSpot_rype() {
        return spot_rype;
    }

    public void setSpot_rype(String spot_rype) {
        this.spot_rype = spot_rype;
    }

    @Override
    public String toString() {
        return "order_spot{" +
                "id_order_spot=" + id_order_spot +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", spot_rype='" + spot_rype + '\'' +
                ", spot_type=" + spot_type +
                '}';
    }
}
