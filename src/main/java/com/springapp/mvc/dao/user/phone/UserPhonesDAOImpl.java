package com.springapp.mvc.dao.user.phone;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.user.user_phone;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
@Repository("userPhonesDAO")
public class UserPhonesDAOImpl extends AbstractDao<Integer, user_phone> implements UserPhonesDAO {

    @SuppressWarnings("unchecked")
    public List<user_phone> findAllPhones() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("phone_number"));
        return (List<user_phone>) criteria.list();
    }

    public user_phone findById(int id_phone) {
        return getByKey(id_phone);
    }

    public user_phone findByNumber(String phone_number) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone_number", phone_number));
        return (user_phone) criteria.uniqueResult();
    }
}
