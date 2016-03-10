package com.springapp.mvc.dao.user.role;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.user.user_role;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 22.02.2016.
 */
@Repository("userRoleDAO")
public class UserRoleDAOImpl extends AbstractDao<Integer,user_role> implements UserRoleDAO {

    @SuppressWarnings("unchecked")
    public List<user_role> findAllRoles() {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("user_role"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<user_role> list = (List<user_role>) criteria.list();
        return list;
    }

    public user_role findByIdRole(int id_role) {
        user_role userRole = getByKey(id_role);
        if(userRole != null){
            Hibernate.initialize(userRole.getUser());
        }
        return userRole;
    }

}
