package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 16.03.2016.
 */
@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDao<Integer, order> implements OrderDAO{
    @Override
    public order findById(int id_order) {

        return getByKey(id_order);
    }

    @Override
    public order findByDate(String date_order) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("date_order",date_order));
        return (order) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<order> findAllOrders() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id_order"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<order>) criteria.list();
    }

    @Override
    public void save(order order) {
        persist(order);
    }

    @Override
    public void deleteById(int id_order) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_order",id_order));
        order order = (order) criteria.uniqueResult();
        delete(order);
    }
}
