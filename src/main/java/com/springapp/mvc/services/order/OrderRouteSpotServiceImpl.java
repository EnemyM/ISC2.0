package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.OrderRouteSpotDAO;
import com.springapp.mvc.model.order.order_route_spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 09.04.2016.
 */
@Service("orderRouteSpotService")
@Transactional
public class OrderRouteSpotServiceImpl implements OrderRouteSpotService {

    @Autowired
    OrderRouteSpotDAO dao;

    @Override
    public order_route_spot findRouteSpotById(int id_order_route_spot) {
        return dao.findRouteSpotById(id_order_route_spot);
    }

    @Override
    public order_route_spot findRouteSpotByName(String name_spot) {
        return dao.findRouteSpotByName(name_spot);
    }

    @Override
    public List<order_route_spot> findAllOrderSpots() {
        return dao.findAllRouteSpots();
    }

    @Override
    public void saveOrderSpot(order_route_spot order_route_spot) {
        dao.saveRouteSpot(order_route_spot);
    }

    @Override
    public void deleteOrderSpotById(int id_order_route_spot) {
        dao.deleteRouteSpotById(id_order_route_spot);
    }
}
