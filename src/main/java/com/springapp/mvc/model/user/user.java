package com.springapp.mvc.model.user;

import com.springapp.mvc.model.order.order;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Anton on 24.01.2016.
 */
@Entity
@Table(name = "user")
public class user {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NotEmpty
    @Column(name = "name_firm")
    private String name_firm;

    @NotEmpty
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty
    @Column(name = "last_name")
    private String last_name;

    @NotEmpty
    @Column(name = "email_user")
    private String email_user;

    @NotEmpty
    @Column(name = "user_password")
    private String user_password;

    @NotEmpty
    @Column(name = "address_user")
    private String address_user;

    @Column(name = "enabled")
    private boolean enabled;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<user_phones> user_phones = new HashSet<user_phones>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<order> orders = new HashSet<order>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<user_role> user_role = new HashSet<user_role>();

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getName_firm() {
        return name_firm;
    }

    public void setName_firm(String name_firm) {
        this.name_firm = name_firm;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getAddress_user() {
        return address_user;
    }

    public void setAddress_user(String address_user) {
        this.address_user = address_user;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<user_phones> getUser_phones() {
        return user_phones;
    }

    public void setUser_phones(Set<user_phones> clients_phones) {
        this.user_phones = clients_phones;
    }

    public Set<order> getOrders() {
        return orders;
    }

    public void setOrders(Set<order> orders) {
        this.orders = orders;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<com.springapp.mvc.model.user.user_role> getUser_role() {
        return user_role;
    }

    public void setUser_role(Set<com.springapp.mvc.model.user.user_role> user_role) {
        this.user_role = user_role;
    }

    public void addPhone(user_phones phone){
        phone.setUser(this);
        getUser_phones().add(phone);
    }
    public void removePhone(com.springapp.mvc.model.user.user_phones phone){
        getUser_phones().remove(phone);
    }
    public void addOrder(order order){
        order.setUser(this);
        getOrders().add(order);
    }
    public void removeOrder(order order){
        getOrders().remove(order);
    }

    public void addRole(user_role role){
        role.setUser(this);
        getUser_role().add(role);
    }
    public void removeRole(user_role role){
        getUser_role().remove(role);
    }

    @Override
    public String toString() {
        return "user{" +
                "id_user=" + id_user +
                ", name_firm='" + name_firm + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email_user='" + email_user + '\'' +
                ", user_password='" + user_password + '\'' +
                ", address_user='" + address_user + '\'' +
                ", enabled=" + enabled +
                ", user_phones=" + user_phones +
                ", orders=" + orders +
                ", user_role=" + user_role +
                '}';
    }
}
