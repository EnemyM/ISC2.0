package com.springapp.mvc.model.user;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phone_type")
public class phone_type {

    @Id
    @Column(name = "id_phone_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone_type;

    @NotEmpty
    @Column(name = "type_phone")
    private String type_phone;

    @OneToMany(mappedBy = "phone_type",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<user_phones> phones = new HashSet<user_phones>();

    public Integer getId_phone_type() {
        return id_phone_type;
    }

    public void setId_phone_type(Integer id_phone_type) {
        this.id_phone_type = id_phone_type;
    }

    public String getType_phone() {
        return type_phone;
    }

    public void setType_phone(String type_phone) {
        this.type_phone = type_phone;
    }

    public Set<user_phones> getPhones() {
        return phones;
    }

    public void setPhones(Set<user_phones> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "phone_type{" +
                "id_phone_type=" + id_phone_type +
                ", type_phone='" + type_phone + '\'' +
                ", phones=" + phones +
                '}';
    }
}
