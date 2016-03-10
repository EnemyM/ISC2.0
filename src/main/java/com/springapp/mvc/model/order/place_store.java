package com.springapp.mvc.model.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 25.01.2016.
 */
@Entity
@Table(name = "place_store")
public class place_store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place_store")
    private Integer id_place_store;

    @NotEmpty
    @Column(name = "address_store")
    private String address_store;

    @NotEmpty
    @Column(name = "place_latitude")
    private Float place_latitude;

    @NotEmpty
    @Column(name = "place_longitude")
    private Float place_longitude;

    public Integer getId_place_store() {
        return id_place_store;
    }

    public void setId_place_store(Integer id) {
        this.id_place_store = id;
    }

    public String getAddress_store() {
        return address_store;
    }

    public void setAddress_store(String address_store) {
        this.address_store = address_store;
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
        return "id place store: " + id_place_store + ", address store: " + address_store +
                ", latitude store: " + place_latitude + ", place longitude: " + place_longitude;
    }
}
