package com.springapp.mvc.dao.user.phone;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.user.user_phones;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
@Repository("userPhonesDAO")
public class UserPhonesDAOImpl extends AbstractDao<Integer, user_phones> implements UserPhonesDAO {

    @SuppressWarnings("unchecked")
    public List<user_phones> findAllPhones() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("phone_number"));
        return (List<user_phones>) criteria.list();
    }

    public user_phones findById(int id_phone) {
        return getByKey(id_phone);
    }

    public user_phones findByNumber(String phone_number) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone_number", phone_number));
        return (user_phones) criteria.uniqueResult();
    }
}
