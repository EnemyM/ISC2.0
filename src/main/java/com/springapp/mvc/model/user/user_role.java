package com.springapp.mvc.model.user;

import javax.persistence.*;

/**
 * Created by Anton on 18.02.2016.
 */
@Entity
@Table(name = "user_role")
public class user_role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Integer id_user_role;


    @Column(name = "user_role")
    private String user_role;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private user user;

    public user_role() {
    }

    public user_role(String user_role) {
        this.user_role = user_role;
    }

    public Integer getId_user_role() {
        return id_user_role;
    }

    public void setId_user_role(Integer id_user_role) {
        this.id_user_role = id_user_role;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public com.springapp.mvc.model.user.user getUser() {
        return user;
    }

    public void setUser(com.springapp.mvc.model.user.user user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "user_role{" +
                "id_user_role=" + id_user_role +
                ", user_role='" + user_role + '\'' +
                ", user=" + user +
                '}';
    }
}
