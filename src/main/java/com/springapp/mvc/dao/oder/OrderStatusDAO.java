package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.order_status;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface OrderStatusDAO {

    order_status findByName(String status);
    order_status findById(int id_status);
    List<order_status> findAllStatuses();

    void save(order_status status);
    void deleteById(int id_order_status);

}
