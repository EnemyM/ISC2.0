package com.springapp.mvc.services.user;

import com.springapp.mvc.dao.user.UserDAO;
import com.springapp.mvc.model.user.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    public user findById(int id_user) {
        return dao.findById(id_user);
    }


    public user findByEmail(String email) {
        List<user> list = dao.findAllUsers();
        for (user client: list){
            if (client.getEmail_user().equalsIgnoreCase(email)) {
                return client;
            }
        }
        return null;
    }

    public void saveUser(user clients) {
        dao.save(clients);
    }

    public void updateUser(user clients) {
        user entity = dao.findById(clients.getId_user());
        if (entity != null){
            entity.setFirst_name(clients.getFirst_name());
            entity.setLast_name(clients.getLast_name());
            entity.setUser_phones(clients.getUser_phones());
            entity.setEmail_user(clients.getEmail_user());
            entity.setUser_password(clients.getUser_password());

        }
    }

    public void deleteById(int id_client) {

        dao.deleteById(id_client);
    }

    public List<user> findAllUsers() {

        return dao.findAllUsers();
    }


    public boolean isUserExist(String email_user) {
        return findByEmail(email_user) != null;
    }


    public boolean isUserEmailUnique(Integer id, String email_client) {
        user client = findByEmail(email_client);
        return (client == null || ((id != null) && (client.getId_user() == id)));
    }

}
