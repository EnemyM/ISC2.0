package com.springapp.mvc.model.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 26.04.2016.
 */
@Entity
public class spot_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spot_type")
    private Integer id_spot_type;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "spot_type", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<order_spot> order_spots = new HashSet<order_spot>();

    public Set<order_spot> getOrder_spots() {
        return order_spots;
    }

    public void setOrder_spots(Set<order_spot> order_spots) {
        this.order_spots = order_spots;
    }

    public Integer getId_spot_type() {
        return id_spot_type;
    }

    public void setId_spot_type(Integer id_spot_type) {
        this.id_spot_type = id_spot_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "spot_type{" +
                "id_spot_type=" + id_spot_type +
                ", type='" + type + '\'' +
                '}';
    }
}
