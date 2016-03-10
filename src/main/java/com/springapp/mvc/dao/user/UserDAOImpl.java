package com.springapp.mvc.dao.user;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.user.user;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractDao<Integer, user> implements UserDAO {

    public user findById(int id_user) {
        user user = getByKey(id_user);
        if (user != null){
            Hibernate.initialize(user.getUser_phones());
        }
        return user;
    }

    public void save(user clients) {
        persist(clients);
    }

    public void deleteById(int id_user) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_user", id_user));
        user user = (user)criteria.uniqueResult();
        delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<user> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("first_name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<user> users = (List<user>)criteria.list();// to avoid duplicates
        return users;
    }

    public user findByEmail(String email_user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email_user", email_user));
        return (user) criteria.uniqueResult();
    }


}
