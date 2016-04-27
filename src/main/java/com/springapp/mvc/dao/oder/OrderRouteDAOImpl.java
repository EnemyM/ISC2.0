package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.order_route;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
@Repository("orderRouteDAO")
public class OrderRouteDAOImpl extends AbstractDao<Integer,order_route> implements OrderRouteDAO{
    @Override
    public order_route findOrderRouteById(int id_order_route) {
        order_route route = getByKey(id_order_route);
        return route;
    }

    @Override
    public order_route findOrderRouteByEndRoute(String end_route) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("end_route",end_route));
        return (order_route)criteria.uniqueResult();
    }

    @Override
    public List<order_route> findAllOrderRoutes() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id_order_route"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// to avoid duplication
        return (List<order_route>) criteria.list();
    }

    @Override
    public void saveOrderRoute(order_route order_route) {
        persist(order_route);
    }

    @Override
    public void deleteOrderRouteById(int id_order_route) {
        order_route route = getByKey(id_order_route);
        delete(route);
    }
}
