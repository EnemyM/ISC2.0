package com.springapp.mvc.model.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Anton on 24.01.2016.
 */
@Entity
@Table(name = "user_phones")
public class user_phones {
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

    public  String toString(){
        return "id phone: " + id_phone + ", phone number: " + phone_number +
                ", id user: " + user.getId_user();
    }
}
