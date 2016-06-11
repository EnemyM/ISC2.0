package com.springapp.mvc.model.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 24.01.2016.
 */
@Entity
@Table(name = "user_phone")
public class user_phone {
    @Id
    @Column(name = "id_phone")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone;

    @NotEmpty
    @Column(name = "phone_number")
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private user user;

    @ManyToOne
    @JoinColumn(name = "id_phone_type")
    private phone_type phone_type;

    public Integer getId_phone() {
        return id_phone;
    }

    public void setId_phone(Integer id_phone) {
        this.id_phone = id_phone;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public com.springapp.mvc.model.user.user getUser() {
        return user;
    }

    public void setUser(com.springapp.mvc.model.user.user user) {
        this.user = user;
    }

    public com.springapp.mvc.model.user.phone_type getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(com.springapp.mvc.model.user.phone_type phone_type) {
        this.phone_type = phone_type;
    }

    @Override
    public String toString() {
        return "user_phone{" +
                "id_phone=" + id_phone +
                ", phone_number='" + phone_number + '\'' +
                ", user=" + user +
                ", phone_type=" + phone_type +
                '}';
    }
}
