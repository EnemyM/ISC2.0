package com.springapp.mvc.services.user.role;

import com.springapp.mvc.dao.user.role.UserRoleDAO;
import com.springapp.mvc.model.user.user_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Anton on 22.02.2016.
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleDAO dao;

    @Override
    public user_role findByRole(String role) {

        List<user_role> roles = dao.findAllRoles();

        for (user_role userRole: roles){
            if (userRole.getUser_role().equalsIgnoreCase(role)){
                return userRole;
            }
        }
        return null;
    }

    @Override
    public user_role findRoleById(int id_role) {
        return dao.findByIdRole(id_role);
    }
}
