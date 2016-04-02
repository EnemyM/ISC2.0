package com.springapp.mvc.dao.user.phone;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.user.phone_type;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 30.03.2016.
 */
@Repository("phoneTypeDAO")
public class PhoneTypeDAOImpl extends AbstractDao<Integer,phone_type> implements PhoneTypeDAO {
    @Override
    public phone_type findPhoneTypeById(int id_phone_type) {
        phone_type phone_type = getByKey(id_phone_type);
        return phone_type;
    }

    @Override
    public phone_type findPhoneTYpeByType(String phone_type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone_type",phone_type));

        return (phone_type) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<phone_type> findAllPhoneType() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("phone_type"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<phone_type>) criteria.list();
    }

    @Override
    public void savePhoneType(phone_type phone_type) {
        persist(phone_type);
    }

    @Override
    public void deletePhoneTypeById(int id_phone_type) {
        phone_type phone_type = getByKey(id_phone_type);
        delete(phone_type);
    }
}
