package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.order_route_spot;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
public interface OrderRouteSpotDAO {
    order_route_spot findRouteSpotById(int id_order_route_spot);
    order_route_spot findRouteSpotByName(String name_spot);

    List<order_route_spot> findAllRouteSpots();

    void saveRouteSpot(order_route_spot order_route_spot);
    void deleteRouteSpotById(int id_orderRoute_spot);
}
