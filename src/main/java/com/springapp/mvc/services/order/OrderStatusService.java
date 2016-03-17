package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.order_status;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface OrderStatusService {

    order_status findStatusById(int id_status);
    order_status findTypeByName(String type);
    List<order_status> findAllTypes();

    void save(order_status order_status);
    void deleteById(int id_order_status);
}
