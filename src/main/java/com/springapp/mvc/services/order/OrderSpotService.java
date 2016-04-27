package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.order_spot;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
public interface OrderSpotService {
    order_spot findById(int id_order_spot);
    order_spot findByType(String type);

    List<order_spot> findAll();

    void save(order_spot order_spot);

    void deleteById(int id_order_spot);

}
