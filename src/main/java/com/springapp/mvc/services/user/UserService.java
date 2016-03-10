package com.springapp.mvc.services.user;

import com.springapp.mvc.model.user.user;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
public interface UserService {

    user findById(int id_user);
    user findByEmail(String name_firm);
    void saveUser(user user);
    void updateUser(user user);
    void deleteById(int id_user);
    List<user> findAllUsers();
    boolean isUserExist(String email_user);
    boolean isUserEmailUnique(Integer id, String email_user);
}
