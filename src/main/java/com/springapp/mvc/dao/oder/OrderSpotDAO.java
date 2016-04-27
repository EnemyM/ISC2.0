package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.order_spot;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
public interface OrderSpotDAO {

    order_spot findOrderSpotById(int id_order_spot);

    order_spot findOrderSpotByAddress(String address);

    List<order_spot> finaAllOrderSpots();

    void saveOrderSpot(order_spot order_spot);

    void deleteOrderSpot(int id_order_spot);
}
