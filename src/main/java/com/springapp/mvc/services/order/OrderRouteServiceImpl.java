package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.OrderRouteDAO;
import com.springapp.mvc.model.order.order_route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
@Service("orderRouteService")
@Transactional
public class OrderRouteServiceImpl implements OrderRouteService {

    @Autowired
    OrderRouteDAO orderRouteDAO;

    @Override
    public order_route findOrderRouteById(int id_order_route) {
        return orderRouteDAO.findOrderRouteById(id_order_route);
    }

    @Override
    public order_route findOrderRouteByEnd(String end_route) {
        return orderRouteDAO.findOrderRouteByEndRoute(end_route);
    }

    @Override
    public List<order_route> findAllOrderRoutes() {
        return orderRouteDAO.findAllOrderRoutes();
    }

    @Override
    public void saveOrderRoute(order_route order_route) {
        orderRouteDAO.saveOrderRoute(order_route);
    }

    @Override
    public void deleteOrderRouteById(int id_order_route) {
        orderRouteDAO.deleteOrderRouteById(id_order_route);
    }
}
