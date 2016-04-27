package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.order_route_spot;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
public interface OrderRouteSpotService {
    order_route_spot findRouteSpotById(int id_order_route_spot);
    order_route_spot findRouteSpotByName(String name_spot);

    List<order_route_spot> findAllOrderSpots();

    void saveOrderSpot(order_route_spot order_route_spot);

    void deleteOrderSpotById(int id_order_route_spot);
}
