package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.order;

import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 16.03.2016.
 */

public interface OrderService {

    order findById(int id_order);
    order findByDateOrder(Date date_order);
    List<order> findAllOrders();

    void saveOrder(order order);
    void updateOrder(order order);
    void deleteOrderById(int id_order);
}
