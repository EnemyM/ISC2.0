package com.springapp.mvc.services.user.role;

import com.springapp.mvc.model.user.user_role;

/**
 * Created by Anton on 22.02.2016.
 */
public interface UserRoleService {
   user_role findByRole(String role);
   user_role findRoleById(int id_role);
}
