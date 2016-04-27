package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.order_spot;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
@Repository("orderSpotDAO")
public class OrderSpotDAOImpl extends AbstractDao<Integer,order_spot> implements OrderSpotDAO{

    @Override
    public order_spot findOrderSpotById(int id_order_spot) {
        return (order_spot)getByKey(id_order_spot);
    }

    @Override
    public order_spot findOrderSpotByAddress(String address) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("address",address));
        return (order_spot) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<order_spot> finaAllOrderSpots() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id_order_spot"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<order_spot>)criteria.list();
    }

    @Override
    public void saveOrderSpot(order_spot order_spot) {
            persist(order_spot);
    }

    @Override
    public void deleteOrderSpot(int id_order_spot) {
        delete((order_spot)getByKey(id_order_spot));
    }
}
