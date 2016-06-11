package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.order;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface OrderDAO {

    order findById(int id_order);
    order findByDate(String date_order);
    List<order> findAllOrders();

    void save(order order);
    void deleteById(int id_order);
}
