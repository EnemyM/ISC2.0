package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.order_route;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
public interface OrderRouteService {
    order_route findOrderRouteById(int id_order_route);
    order_route findOrderRouteByEnd(String end_route);

    List<order_route> findAllOrderRoutes();

    void saveOrderRoute(order_route order_route);
    void deleteOrderRouteById(int id_order_route);
}
