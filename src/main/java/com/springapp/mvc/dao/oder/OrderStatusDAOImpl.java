package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.order_status;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 16.03.2016.
 */
@Repository("orderStatusDAO")
public class OrderStatusDAOImpl extends AbstractDao<Integer, order_status> implements OrderStatusDAO{
    @Override
    public order_status findById(int id_status) {
        order_status status = getByKey(id_status);
        return status;
    }

    @Override
    public List<order_status> findAllStatuses() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("order_status"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<order_status> statuses = (List<order_status>) criteria.list();
        return statuses;
    }

    @Override
    public void save(order_status status) {
        persist(status);
    }

    @Override
    public void deleteById(int id_order_status) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_order_status",id_order_status));
        order_status status = (order_status)criteria.uniqueResult();
        delete(status);
    }
}
