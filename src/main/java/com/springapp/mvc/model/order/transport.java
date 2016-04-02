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

    @Column(name = "mix_tonnage")
    private String mix_tonnage;

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

    public String getMix_tonnage() {
        return mix_tonnage;
    }

    public void setMix_tonnage(String mix_tonnage) {
        this.mix_tonnage = mix_tonnage;
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

    @Override
    public String toString() {
        return "transport{" +
                "id_transport=" + id_transport +
                ", name_transport='" + name_transport + '\'' +
                ", mix_tonnage='" + mix_tonnage + '\'' +
                ", max_tonnage='" + max_tonnage + '\'' +
                ", orders=" + orders +
                '}';
    }
}
