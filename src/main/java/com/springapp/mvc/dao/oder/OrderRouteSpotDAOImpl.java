package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.order_route_spot;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
@Repository("orderRouteSpotDAO")
public class OrderRouteSpotDAOImpl extends AbstractDao<Integer,order_route_spot> implements OrderRouteSpotDAO {
    @Override
    public order_route_spot findRouteSpotById(int id_order_route_spot) {
        order_route_spot route_spot = getByKey(id_order_route_spot);
        return route_spot;
    }

    @Override
    public order_route_spot findRouteSpotByName(String name_spot) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name_spot",name_spot));

        return (order_route_spot) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<order_route_spot> findAllRouteSpots() {

        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("name_spot"));

        return (List<order_route_spot>) criteria.list();
    }

    @Override
    public void saveRouteSpot(order_route_spot order_route_spot) {
        persist(order_route_spot);
    }

    @Override
    public void deleteRouteSpotById(int id_orderRoute_spot) {
        order_route_spot route_spot = getByKey(id_orderRoute_spot);
        delete(route_spot);
    }
}
