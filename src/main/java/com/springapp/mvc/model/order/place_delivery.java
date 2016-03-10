package com.springapp.mvc.model.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 25.01.2016.
 */
@Entity
@Table(name = "place_delivery")
public class place_delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place_delivery")
    private Integer id_place_delivery;

    @NotEmpty
    @Column(name = "address_delivery")
    private String address_delivery;

    @NotEmpty
    @Column(name = "place_latitude")
    private Float place_latitude;

    @NotEmpty
    @Column(name = "place_longitude")
    private Float place_longitude;


    public Integer getId_place_delivery() {
        return id_place_delivery;
    }

    public void setId_place_delivery(Integer id_placePdelivery) {
        this.id_place_delivery = id_placePdelivery;
    }

    public String getAddress_delivery() {
        return address_delivery;
    }

    public void setAddress_delivery(String address_delivery) {
        this.address_delivery = address_delivery;
    }

    public Float getPlace_latitude() {
        return place_latitude;
    }

    public void setPlace_latitude(Float place_latitude) {
        this.place_latitude = place_latitude;
    }

    public Float getPlace_longitude() {
        return place_longitude;
    }

    public void setPlace_longitude(Float place_longitude) {
        this.place_longitude = place_longitude;
    }


    public String toString(){
        return "id place delivery: " + id_place_delivery + ", address delivery: " + address_delivery +
                ", place latitude: " + place_latitude + ", place longitude" + place_longitude;
    }
}
