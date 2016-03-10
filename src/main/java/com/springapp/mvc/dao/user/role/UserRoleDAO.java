package com.springapp.mvc.dao.user.role;

import com.springapp.mvc.model.user.user_role;

import java.util.List;

/**
 * Created by Anton on 22.02.2016.
 */
public interface UserRoleDAO {

    List<user_role> findAllRoles();
    user_role findByIdRole(int id_role);
}
